package com.zxiaofan.uisizetest36;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//Android 的规定，在160dpi 的屏幕上，1dp 等于1px，而在320dpi 的屏幕上，1dp就等于2px。
public class MainActivity extends AppCompatActivity {
    private String Tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //通过代码来得知当前屏幕的密度值
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.d(Tag, "xdpi is:" + xdpi);
        Log.d(Tag, "ydpi is:" + ydpi);
    }
}
