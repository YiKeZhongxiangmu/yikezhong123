
package com.example.yikezhong123.ui.sliding.mainlogin.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yikezhong123.Component.DaggerHttpComponent;
import com.example.yikezhong123.MainActivity;
import com.example.yikezhong123.R;
import com.example.yikezhong123.bean.UserBean;
import com.example.yikezhong123.ui.base.BaseActivity;
import com.example.yikezhong123.ui.sliding.mainlogin.reg.ZhuceActivity;
import com.example.yikezhong123.utils.SharedPreferencesUtils;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.view {

    private TextView zhuce;
    /**
     * 注册账号
     */
    private ImageView login_back;
    private TextView youkelogin;
    /**
     * 游客登录
     */
    private EditText login_mobile;
    /**
     * 账号
     */
    private EditText login_pwd;
    /**
     * 密码
     */
    private Button loginBtn;
    private TextView wangjipwd;
    /**
     * 忘记密码
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    public void initView(){
        zhuce=(TextView) findViewById(R.id.zhuce);
        login_back=(ImageView) findViewById(R.id.login_back);
        youkelogin=(TextView) findViewById(R.id.youkelogin);
        login_mobile=(EditText) findViewById(R.id.login_mobile);
        login_pwd=(EditText) findViewById(R.id.login_pwd);
        loginBtn=(Button) findViewById(R.id.loginBtn);
        wangjipwd=(TextView) findViewById(R.id.wangjipwd);

        youkelogin.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public int getContentLayout() {
        return R.layout.login_layout;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder().build().inject(this);
    }

    @Override
    public void initView(View view) {

    }


    @Override
    public void loginSuccess(UserBean userBean) {
        UserBean.DataBean data = userBean.getData();
        String mobile=data.getMobile();
        SharedPreferencesUtils.setParam(this, "uid", userBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(this, "name", userBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(this, "iconUrl", userBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(this, "token", userBean.getData().getToken() + "");
        finish();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zhuce:
                Intent inte=new Intent(LoginActivity.this,ZhuceActivity.class);
                startActivity(inte);
                break;
            case R.id.youkelogin:
                finish();
                break;
            case R.id.loginBtn:
                String mobiles = login_mobile.getText().toString();
                String password = loginBtn.getText().toString();
                mPresenter.login(mobiles, password);
                break;
            default:
                break;
        }
    }
}
