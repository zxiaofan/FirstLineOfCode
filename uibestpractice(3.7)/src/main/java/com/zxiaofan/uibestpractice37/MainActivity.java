package com.zxiaofan.uibestpractice37;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();// 初始化消息数据
        adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();//有新消息时，刷新ListView中的显示
                    msgListView.setSelection(msgList.size()); //将ListView定位到最后一行
                    inputText.setText(""); //清空输入框
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg = new Msg("Hello boy.", Msg.TYPE_RECEIVED);
        msgList.add(msg);
        msgList.add(new Msg("Hi,Girl.", Msg.TYPE_SEND));
        msgList.add(new Msg("Today is nice.", Msg.TYPE_RECEIVED));
    }
}
