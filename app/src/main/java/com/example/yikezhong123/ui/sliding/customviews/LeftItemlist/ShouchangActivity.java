package com.example.yikezhong123.ui.sliding.customviews.LeftItemlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.yikezhong123.R;

public class ShouchangActivity extends AppCompatActivity {

    private TextView back_text;
    private TextView delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shouchang_activity_layout);
        
        initView();
    }

    private void initView() {
        back_text=(TextView) findViewById(R.id.back_text);
        delete=(TextView) findViewById(R.id.delete);

        back_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
