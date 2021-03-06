package com.example.yikezhong123;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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
import com.example.yikezhong123.ui.chhuangzuo.ChuangzuoActivity;
import com.example.yikezhong123.ui.duanzi.Frag_duanzi;
import com.example.yikezhong123.ui.shiping.Frag_shiping;
import com.example.yikezhong123.ui.sliding.customviews.LeftItemlist.GuanzhuActivity;
import com.example.yikezhong123.ui.sliding.customviews.LeftItemlist.ShouchangActivity;
import com.example.yikezhong123.ui.sliding.customviews.LeftItemlist.SousuoActivity;
import com.example.yikezhong123.ui.sliding.customviews.LeftItemlist.TongzhiActivity;
import com.example.yikezhong123.ui.sliding.customviews.SettingActivity;
import com.example.yikezhong123.ui.sliding.mainlogin.MainLoginActivity;
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

    private RadioButton mBtn3;
    private RadioGroup mRg;
    private SlidingMenu menu;
    private LinearLayout lin;
    private TuiJianFragment tuiJianFragment;
    private Frag_duanzi frag_duanzi;
    private Frag_shiping frag_shiping;
    private BottomBar bottomBar;
    private LinearLayout guanzhu;
    private LinearLayout shoucang;
    private LinearLayout sousuo;
    private LinearLayout tongzhi;
    private LinearLayout shezhi;
    private LinearLayout guan;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //创作
     mChuangzuo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this, ChuangzuoActivity.class);
             startActivity(intent);
         }
     });

        bottomBar=findViewById(R.id.bottom_bar);
        //底部导航
        bottomBar.setContainer(R.id.flout)
                .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                .addItem(TuiJianFragment.class,"推荐",R.drawable.tuijian1,
                        R.drawable.tuijian2)
                .addItem(Frag_duanzi.class,"段子",R.drawable.duanzi1,
                        R.drawable.duanzi2)
                .addItem(Frag_shiping.class,"视屏",R.drawable.shiping1,
                        R.drawable.shipin2)
                .build();
        getMenu();
        //设置点击事件
        setLisenter();

        shezhi=menu.findViewById(R.id.shezhi);
        //设置
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(MainActivity.this,SettingActivity.class);
                startActivity(inte);
            }
        });
    }

    private void getMenu() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
       /* //滑动显示的布局文件
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);*/
        //触摸哪里可以发生滑动
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //屏幕宽度
        int v = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
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
       //头像进入登录页面点击事件
        lin = menu.findViewById(R.id.lin1);
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainLoginActivity.class);
                startActivity(intent);

            }
        });
        /* my_head.setOnClickListener(this);*/

        //我的关注点击事件
        guanzhu=menu.findViewById(R.id.guanzhu);
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(MainActivity.this,GuanzhuActivity.class);
                startActivity(inte);
            }
        });

        //我的收藏点击事件
        shoucang=menu.findViewById(R.id.shoucang);
        shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(MainActivity.this,ShouchangActivity.class);
                startActivity(inte);
            }
        });

        //搜索好友点击事件
        sousuo=menu.findViewById(R.id.sousuo);
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte1=new Intent(MainActivity.this,SousuoActivity.class);
                startActivity(inte1);
            }
        });

        //消息通知击事件
        tongzhi=menu.findViewById(R.id.tongzhi);
        tongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte1=new Intent(MainActivity.this,TongzhiActivity.class);
                startActivity(inte1);
            }
        });


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

    }

    private void initView() {
        mNameImage = (SimpleDraweeView) findViewById(R.id.name_image);
        mChuangzuo = (ImageView) findViewById(R.id.chuangzuo);
        mLay = (LinearLayout) findViewById(R.id.lay);
        mFlout = (FrameLayout) findViewById(R.id.flout);

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