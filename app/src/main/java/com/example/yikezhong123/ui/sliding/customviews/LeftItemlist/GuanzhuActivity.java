package com.example.yikezhong123.ui.sliding.customviews.LeftItemlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.yikezhong123.R;

public class GuanzhuActivity extends AppCompatActivity {

    private TextView back_text;
    private TextView remeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guanzhu_activity_layout);

        initView();
    }

    private void initView() {
        back_text=(TextView) findViewById(R.id.back_text);
        remeng=(TextView) findViewById(R.id.remeng);
        back_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        remeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(GuanzhuActivity.this,RemengActivity.class);
                startActivity(inte);
            }
        });
    }
}
