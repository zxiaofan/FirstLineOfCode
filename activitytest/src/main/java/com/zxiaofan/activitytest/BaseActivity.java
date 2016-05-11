package com.zxiaofan.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by yunhai on 2016/5/11.
 */
public class BaseActivity extends Activity {
    String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName()); // 获取当前实例的类名
        ActivityCollector.addActivity(this);
    }

    @Override
    /*将要销毁的活动从活动管理器移除*/
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
