package com.example.yikezhong123.ui.sliding.mainlogin.reg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yikezhong123.Component.DaggerHttpComponent;
import com.example.yikezhong123.MainActivity;
import com.example.yikezhong123.R;
import com.example.yikezhong123.ui.base.BaseActivity;
import com.example.yikezhong123.ui.sliding.mainlogin.login.LoginActivity;

public class ZhuceActivity extends BaseActivity<ZhucePresenter> implements View.OnClickListener,ZhuceContract.View{

    private ImageView login_back;
    private TextView yiyou;
    private EditText phone;
    private EditText login_pwd;
    private Button zhuceBtn;
    private TextView youkelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

    }

    private void initView() {
        zhuceBtn=(Button) findViewById(R.id.zhuceBtn);
        login_back=(ImageView) findViewById(R.id.login_back);
        yiyou=(TextView) findViewById(R.id.yiyou);
        phone=(EditText) findViewById(R.id.phone);
        login_pwd=(EditText) findViewById(R.id.login_pwd);
        youkelogin=(TextView) findViewById(R.id.youkelogin);

        youkelogin.setOnClickListener(this);

        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhuceBtn:
                Toast.makeText(ZhuceActivity.this,"登录",Toast.LENGTH_SHORT);
                String mobile = phone.getText().toString();
                String password = login_pwd.getText().toString();
                mPresenter.reg(mobile, password);
                Intent intent = new Intent(ZhuceActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.youkelogin:
                Intent intent1 = new Intent(ZhuceActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
                default:
                    break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_zhuce;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void regSuccess() {
        Toast.makeText(ZhuceActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
