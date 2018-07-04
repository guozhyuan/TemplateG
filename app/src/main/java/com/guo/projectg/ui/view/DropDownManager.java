package com.guo.projectg.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class DropDownManager {

    void init(Context context, int layoutRes) {
        View popWindows = LayoutInflater.from(context).inflate(layoutRes, null, false);
        PopupWindow mPopupWindow = new PopupWindow(popWindows, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
    }

}
