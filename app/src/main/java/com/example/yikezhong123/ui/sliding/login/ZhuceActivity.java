package com.example.yikezhong123.ui.sliding.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yikezhong123.R;

public class ZhuceActivity extends AppCompatActivity {

    private TextView zhuceBtn;
    private ImageView login_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        initView();

    }

    private void initView() {
        zhuceBtn=(TextView) findViewById(R.id.zhuceBtn);
        login_back=(ImageView) findViewById(R.id.login_back);

        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
