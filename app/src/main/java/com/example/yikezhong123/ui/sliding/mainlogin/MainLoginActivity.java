package com.example.yikezhong123.ui.sliding.mainlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yikezhong123.R;
import com.example.yikezhong123.ui.sliding.mainlogin.login.LoginActivity;

public class MainLoginActivity extends AppCompatActivity {

    private TextView otherlogin;
    private ImageView login_back;
    private ImageView weixinlogin;
    private ImageView qqlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlogin_layout);
        initView();


        otherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        login_back=(ImageView) findViewById(R.id.login_back);
        otherlogin = findViewById(R.id.otherlogin);
        weixinlogin=(ImageView) findViewById(R.id.weixinlogin);
        qqlogin=(ImageView) findViewById(R.id.qqlogin);

        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
