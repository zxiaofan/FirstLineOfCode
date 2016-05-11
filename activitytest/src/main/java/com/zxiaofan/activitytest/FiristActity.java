package com.zxiaofan.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
//                Intent intent = new Intent("com.zxiaofan.activitytest.ACTION_START");
//                intent.addCategory("com.zxiaofan.activitytest.MY_CATEGORY"); //隐式Intent
//                Intent intent=new Intent(Intent.ACTION_VIEW); // 调用系统浏览器
//                intent.setData(Uri.parse("http://www.baidu.com"));
                // 调用系统拨号界面
//                Intent intent=new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:1008611"));
                // Intent向下一个活动传递数据
//                String data="Hello Second";
//                Intent intent=new Intent(FiristActity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
                // 返回数据给上一个活动
                Intent intent = new Intent(FiristActity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    // onActi 即自动补全
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1: // 检查requestCode判断数据源（确实是从SecondActivity传来的）
                if (resultCode == RESULT_OK) { // resultCode 判断处理是否成功
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FiristActivity", returnData);
                }
                break;
            default:
        }
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
