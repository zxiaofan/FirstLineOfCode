package com.zxiaofan.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import zxiaofan.com.activitytest.R;

/**
 * Created by lenovo on 2016/5/10.
 */
public class FiristActity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FiristActity.this, "You Click Me!", Toast.LENGTH_SHORT).show();
//                finish();
//                Intent intent = new Intent(FiristActity.this, SecondActivity.class); // 显示Intent
                Intent intent = new Intent("com.example.yunhai.activitytest.ACTION_START");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
