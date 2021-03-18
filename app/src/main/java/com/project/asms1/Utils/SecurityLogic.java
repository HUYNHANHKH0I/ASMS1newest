package com.project.asms1.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.google.gson.Gson;
import com.project.asms1.config.MyConfig;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityLogic {

    private static SharedPreferences sharedPreferences;
    public static String convertByteToHex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password) && password.length() >=6;
    }

    public static boolean isValidUserName(String username) {
        return !TextUtils.isEmpty(username);
    }

    public static SharedPreferences getPreferenceInstance(Context context) throws GeneralSecurityException, IOException {
        String masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
        try {
            if(sharedPreferences == null) {
                sharedPreferences = EncryptedSharedPreferences
                        .create(MyConfig.specificFileToStore,
                                masterKey,
                                context,
                                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
                return sharedPreferences;
            }else {
                return sharedPreferences;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void storeTokens(String value) {
            sharedPreferences.edit().putString(MyConfig.key,value).apply();
    }

    public static String getTokens() {
        return sharedPreferences.getString(MyConfig.key,null);

    }

    public static void deleteTokens() {
        sharedPreferences.edit().remove(MyConfig.key).apply();
    }

    public static void saveObjectToSharedPreference(Context context, String preferenceFileName, String serializedObjectKey, Object object) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        final Gson gson = new Gson();
        String serializedObject = gson.toJson(object);
        sharedPreferencesEditor.putString(serializedObjectKey, serializedObject);
        sharedPreferencesEditor.apply();
    }

    public static <GenericClass> GenericClass getSavedObjectFromPreference(Context context, String preferenceFileName, String preferenceKey, Type classType) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        if (sharedPreferences.contains(preferenceKey)) {
            final Gson gson = new Gson();
            return gson.fromJson(sharedPreferences.getString(preferenceKey, ""), classType);
        }
        return null;
    }
}
