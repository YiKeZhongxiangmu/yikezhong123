package com.example.yikezhong123.ui.sliding.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yikezhong123.R;

public class Login1Activity extends AppCompatActivity {

    private TextView ol;
    private ImageView login_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        initView();

        ol = findViewById(R.id.otherlogin);
        ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login1Activity.this, Login2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        login_back=(ImageView) findViewById(R.id.login_back);
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
