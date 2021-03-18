package com.project.asms1.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.asms1.R;
import com.project.asms1.daos.UserDAO;
import com.project.asms1.model.User;
import com.project.asms1.network.UserUIService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserInforFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserInforFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static User user = UserDAO.currentUser;
    private Button btnLogout;
    private ImageButton btnSetting;
    private TextView txtusername,txtuserfullname,txtuserroll,txtuseremail;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserInforFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserInforFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserInforFragment newInstance(String param1, String param2) {
        UserInforFragment fragment = new UserInforFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_user_infor, container, false);
        btnLogout = contentView.findViewById(R.id.btnLogout);
        btnSetting = contentView.findViewById(R.id.btnSetting);
        txtusername = contentView.findViewById(R.id.txtusername);
        txtuserroll = contentView.findViewById(R.id.txtuserrole);
        txtuserfullname = contentView.findViewById(R.id.txtuserfullname);
        txtuseremail = contentView.findViewById(R.id.txtuseremail);
        initData();
        return contentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        txtuserfullname.setText(user.getName());
        txtuseremail.setText(user.getEmail());
    }

    public void initData() {
        if (user == null) {
            System.out.println("null roi");
        }else {
            System.out.println(user.getName());
            txtusername.setText(user.getUsername());
            txtuserroll.setText(user.getRole() == 1 ? "ADMIN" : "STAFF");
            txtuserfullname.setText(user.getName());
            txtuseremail.setText(user.getEmail());
        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("LOGOUT").setMessage("Are you sure you want to LOGOUT?")
                        .setPositiveButton("No", null).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UserUIService.deleteToken(getContext());
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                }).show();
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),UserSettingActivity.class);
                startActivity(intent);
            }
        });

    }
}