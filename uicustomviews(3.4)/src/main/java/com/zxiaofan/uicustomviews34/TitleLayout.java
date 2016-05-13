package com.zxiaofan.uicustomviews34;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 自定义的标题栏控件
 * Created by yunhai on 2016/5/13.
 */
public class TitleLayout extends LinearLayout {
    //对标题栏布局进行动态加载，借助LayoutInflater 来实现
    //from()方法可以构建出一个LayoutInflate对象
    //用inflate()方法就可以动态加载一个布局文件
    TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        // 为标题栏按钮注册点击事件
        Button b_titleBack= (Button) findViewById(R.id.title_back);
        Button b_titleEdit= (Button) findViewById(R.id.title_edit);
        b_titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        b_titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"You clicked Edit button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
