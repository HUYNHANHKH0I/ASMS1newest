package com.project.asms1.Utils;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.project.asms1.R;

public class PopupMessage {
    View popupView;
    PopupWindow popupWindow;

    public View getPopupView() {
        return popupView;
    }

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

    public void showPopupWindow(final View view, String message) {
        LayoutInflater inflater = (LayoutInflater)view.getContext()
                .getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.popup_message,null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        popupWindow = new PopupWindow(popupView,
                width, height,true);

        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        TextView text = popupView.findViewById(R.id.txtMessage);
        text.setText(message);
//        ((Button)popupView.findViewById(R.id.btnClosePopup)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow.dismiss();
//            }
//        });
    }
}
