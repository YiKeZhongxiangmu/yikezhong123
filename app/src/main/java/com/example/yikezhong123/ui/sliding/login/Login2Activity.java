
package com.example.yikezhong123.ui.sliding.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yikezhong123.R;

public class Login2Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView zhuce;
    private ImageView login_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        initView();

        zhuce.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhuce:
                Intent inte=new Intent(Login2Activity.this,ZhuceActivity.class);
                startActivity(inte);
                break;
                default:
                    break;
        }
    }

    private void initView() {
        zhuce=(TextView) findViewById(R.id.zhuce);
        login_back=(ImageView) findViewById(R.id.login_back);

        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
