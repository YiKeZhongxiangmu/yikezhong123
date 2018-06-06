package com.example.yikezhong123;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.yikezhong123.ui.Recommend.TuiJianFragment;
import com.example.yikezhong123.ui.duanzi.Frag_duanzi;
import com.example.yikezhong123.ui.shiping.Frag_shiping;
import com.example.yikezhong123.ui.sliding.login.Login1Activity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private SimpleDraweeView mNameImage;
    private ImageView mChuangzuo;
    private LinearLayout mLay;
    private FrameLayout mFlout;
    private SimpleDraweeView my_head;
    private TextView my_name;
    private int currentIndex = 1;
    /**
     * 推荐
     */
    private RadioButton mBtn1;
    /**
     * 段子
     */
    private RadioButton mBtn2;
    /**
     * 视频
     */
    private RadioButton mBtn3;
    private RadioGroup mRg;
    private SlidingMenu menu;
    private LinearLayout lin;
    private TuiJianFragment tuiJianFragment;
    private Frag_duanzi frag_duanzi;
    private Frag_shiping frag_shiping;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
         tuiJianFragment = new TuiJianFragment();
          frag_duanzi = new Frag_duanzi();
        frag_shiping = new Frag_shiping();

        fragmentManager.beginTransaction().replace(R.id.flout, tuiJianFragment).commit();
        getMenu();
        //设置点击事件
        setLisenter();

    }



    private void getMenu() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
       /* //滑动显示的布局文件
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);*/
        //触摸哪里可以发生滑动
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //屏幕宽度
        int v = (int) (getResources().getDisplayMetrics().widthPixels * 0.66);
        //侧滑菜单和主界面相融合
        menu.setBehindWidth(v);
        //侧滑菜单显示的宽度
        menu.setFadeDegree(0.35f);

        //为侧滑菜单设置布局
        /* menu.setMenu(R.layout.sliding_left);*/


        View lview = LayoutInflater.from(MainActivity.this).inflate(R.layout.sliding_left, null);
        menu.setMenu(lview);
        //查找侧滑菜单里面的
       /* my_head = menu.findViewById(R.id.my_head);
        my_name = menu.findViewById(R.id.my_name);*/
        lin = menu.findViewById(R.id.lin1);
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login1Activity.class);
                startActivity(intent);

            }
        });
        /* my_head.setOnClickListener(this);*/
    }



    public void setLisenter() {
        //侧拉
        mNameImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开侧滑菜单
                menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏滑出
                menu.showMenu();
                menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//不可以滑出,只可以点击

            }
        });
        //底部导航

        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn1:
                        //首页
                        if (currentIndex == 1) {
                            return;
                        }
                        currentIndex = 1;
                        fragmentManager.beginTransaction().replace(R.id.flout,tuiJianFragment ).commit();
                        break;
                    case R.id.btn2:
                        if (currentIndex == 2) {
                            return;
                        }
                        currentIndex = 2;
                        fragmentManager.beginTransaction().replace(R.id.flout, frag_duanzi).commit();
                        break;
                    case R.id.btn3:
                        if (currentIndex == 3) {
                            return;
                        }
                        currentIndex = 3;
                        fragmentManager.beginTransaction().replace(R.id.flout, frag_shiping).commit();
                        break;


                }
            }
        });

    }

    private void initView() {
        mNameImage = (SimpleDraweeView) findViewById(R.id.name_image);
        mChuangzuo = (ImageView) findViewById(R.id.chuangzuo);
        mLay = (LinearLayout) findViewById(R.id.lay);
        mFlout = (FrameLayout) findViewById(R.id.flout);
        mBtn1 = (RadioButton) findViewById(R.id.btn1);
        mBtn2 = (RadioButton) findViewById(R.id.btn2);
        mBtn3 = (RadioButton) findViewById(R.id.btn3);
        mRg = (RadioGroup) findViewById(R.id.rg);
        Uri uri = Uri.parse("http://tx.haiqq.com/uploads/allimg/160812/102GJ358-9.jpg");
        mNameImage.setImageURI(uri);
        mNameImage.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.name_image:
                break;
        }
    }

    /*@Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {

    }*/
}