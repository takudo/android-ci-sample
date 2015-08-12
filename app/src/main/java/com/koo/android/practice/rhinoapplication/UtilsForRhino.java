package com.koo.android.practice.rhinoapplication;

import android.widget.Toast;

/**
 * Created by koo on 2015/08/12.
 */
public class UtilsForRhino {

    public static void toast(String msg){
        Toast.makeText(AppContloller.getInstance(), msg, Toast.LENGTH_LONG).show();
    }
}
