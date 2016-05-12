package com.zxiaofan.uiwidgettest32;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    String Tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        // 匿名类
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 此处添加Button的逻辑
//                Log.d(Tag, "hi," + Tag);
//            }
//        });
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        // 除匿名类外。亦可使用实现接口的方式注册监听器
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String input = editText.getText().toString();
                if (!input.isEmpty()) {
                    Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();
                }
//                imageView.setImageResource(R.drawable.jelly_bean);
                // 设置水平进度条长度，每点击一次+10
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                break;
            // AlertDialog当前界面弹出一个对话框，置于所有界面之上，屏蔽其他控件的交互能力。用于提示重要信息或警告信息
            case R.id.button2:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You Click OK", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton(
                        "Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You Click Cancel", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                dialog.show();
                break;
            // ProgressDialog和AlertDialog类似，不同的是会显示一个进度条，一般用于表示当前操作耗时，让用户耐心等待
            case R.id.button3:
                ProgressDialog progressDidlog=new ProgressDialog(MainActivity.this);
                progressDidlog.setMessage("Loading...");
                progressDidlog.setCancelable(true);
                progressDidlog.show();
                break;
            default:
                break;
        }
    }
}
