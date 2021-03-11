package com.project.asms1.Utils;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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

    //set needAcceptButton if only close button is needed


    public void showPopupWindow(final View view, String message,boolean needAcceptButton) {
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

        if (!needAcceptButton) {
            ((Button) popupView.findViewById(R.id.btnAcceptPopup)).setVisibility(View.GONE);

        } else {
            ((Button) popupView.findViewById(R.id.btnClosePopup)).setText("Cancel");
        }

        //set function for close button on activities

//        ((Button)popupView.findViewById(R.id.btnClosePopup)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow.dismiss();
//            }
//        });
    }
}
