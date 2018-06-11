package com.example.yikezhong123.ui.sliding.customviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yikezhong123.MainActivity;
import com.example.yikezhong123.R;

public class SettingActivity extends AppCompatActivity {

    private TextView back_text;
    private Button tuichu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        back_text=(TextView) findViewById(R.id.back_text);
        tuichu=(Button) findViewById(R.id.tuichu);
        back_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(SettingActivity.this,MainActivity.class);
                startActivity(inte);
                finish();
                Toast.makeText(SettingActivity.this,"已退出登录",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
