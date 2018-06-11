package com.example.yikezhong123.ui.chhuangzuo;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.yikezhong123.R;
import com.example.yikezhong123.ui.chhuangzuo.czduanzi.Cz_Duanziactivity;
import com.example.yikezhong123.ui.chhuangzuo.czshipin.Cz_ShipinActivity;

public class ChuangzuoActivity extends AppCompatActivity {
    private ImageView chuang_duanzi;
    private ImageView chuang_shiping;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chuangzuo_layout);

        chuang_duanzi= findViewById(R.id.chuang_duanzi);
        chuang_shiping= findViewById(R.id.chuang_shiping);

        //创作段子跳转
        duanzi();
        //创作视频跳转
        shipin();
    }

    private void shipin() {
        chuang_shiping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChuangzuoActivity.this, Cz_ShipinActivity.class);
                startActivity(intent);
            }
        });

    }

    private void duanzi() {
        chuang_duanzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChuangzuoActivity.this, Cz_Duanziactivity.class);
                startActivity(intent);
            }
        });

    }
}
