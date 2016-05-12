package com.zxiaofan.uilayouttest33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relativelayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_RelativeLayout:
                button = (Button) findViewById(R.id.button_RelativeLayout);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, RelativeLayout.class);
                        startActivity(intent);
                    }
                });
                break;
            default:
                break;
        }
    }
}