package com.example.yikezhong123.Component;

import com.example.yikezhong123.Module.HttpModule;
import com.example.yikezhong123.ui.Recommend.GuanZhuFragment;
import com.example.yikezhong123.ui.Recommend.RecommendFragment;
import com.example.yikezhong123.ui.duanzi.Frag_duanzi;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {
   void inject(RecommendFragment recommendFragment);

   void inject(GuanZhuFragment guanZhuFragment);

   void inject(Frag_duanzi duanZiFragment);

}
