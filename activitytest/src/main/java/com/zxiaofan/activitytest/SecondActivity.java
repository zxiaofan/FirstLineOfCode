package com.zxiaofan.activitytest;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import zxiaofan.com.activitytest.R;

/**
 * Created by yunhai on 2016/5/10.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);
    }
}
