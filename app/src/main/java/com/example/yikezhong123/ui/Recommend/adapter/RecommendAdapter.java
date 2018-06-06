package com.example.yikezhong123.ui.Recommend.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.yikezhong123.R;
import com.example.yikezhong123.bean.JokesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<JokesBean.DataBean> list;
    private LayoutInflater inflate;

    public RecommendAdapter(Context context, List<JokesBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflate=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflate.inflate(R.layout.jokes_item, parent, false);
        JViewHolder jViewHolder = new JViewHolder(view);

        return jViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final JViewHolder jViewHolder = (JViewHolder) holder;
        JokesBean.DataBean dataBean = list.get(position);
        jViewHolder.image.setImageURI(dataBean.getUser().getIcon());
        jViewHolder.tv1.setText(dataBean.getUser().getNickname());
        jViewHolder.tv2.setText(dataBean.getCreateTime());
        jViewHolder.tv3.setText(dataBean.getWorkDesc());
        jViewHolder.tv4.setText(dataBean.getWorkDesc());
        jViewHolder.tv5.setText(dataBean.getWorkDesc());

        String url = dataBean.getVideoUrl();
        jViewHolder.video.setUp(url,JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
        Uri uri = Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        jViewHolder.video.thumbImageView.setImageURI(uri);

        /*jViewHolder.video.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                jViewHolder.video.start();
                return true;
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class JViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView image;
        private final JZVideoPlayerStandard video;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final TextView tv4;
        private final TextView tv5;

        public JViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            video = view.findViewById(R.id.video);
            tv1 = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            tv3 = view.findViewById(R.id.tv3);
            tv4 = view.findViewById(R.id.tv4);
            tv5 = view.findViewById(R.id.tv5);
        }

    }
}
