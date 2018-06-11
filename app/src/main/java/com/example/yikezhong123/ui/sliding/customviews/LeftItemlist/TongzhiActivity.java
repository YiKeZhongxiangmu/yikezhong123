package com.example.yikezhong123.ui.sliding.customviews.LeftItemlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.yikezhong123.R;

public class TongzhiActivity extends AppCompatActivity {

    private TextView back_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tongzhi_activity_layout);

        initView();
    }

    private void initView() {
        back_text=(TextView) findViewById(R.id.back_text);

        back_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
