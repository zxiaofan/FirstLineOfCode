package com.zxiaofan.activitytest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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
        // 取出传递过来的数据
//        Intent intent=getIntent();
//        String data=intent.getStringExtra("extra_data");
//        Log.d("SecondActivity",data);
        Button button2= (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("data_return","Hello First");
                setResult(RESULT_OK,intent); // 专门用于向上一个活动返回数据
                finish(); // 销毁活动，需在FirstActivity中重写onActivityResult方法得到返回数据
            }
        });
    }
}
