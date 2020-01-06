package com.example.viewpagerex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private ViewPager viewPager;
//    private ArrayList<View> views;
//    private MyPagerAdapter myPagerAdapter;

    List<String> imageUrls = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        viewPager = findViewById(R.id.viewPager);
//        views = new ArrayList<View>();
//        LayoutInflater li = getLayoutInflater();
//        views.add(li.inflate(R.layout.view_one, null, false));
//        views.add(li.inflate(R.layout.view_two, null, false));
//        views.add(li.inflate(R.layout.view_three, null, false));
//        myPagerAdapter = new MyPagerAdapter(views);
//        viewPager.setAdapter(myPagerAdapter);

        String url1 = "http://guide.7zhou.com/uploads/201207/1341899047s2Q0ex9U.jpg";
        String url2 = "http://img.mp.itc.cn/upload/20170730/61cea6fc2e5743b09272dec279d9346f_th.jpg";
        String url3 = "https://img1.qunarzz.com/travel/d7/1701/bb/e4df8528f2de78b5.jpg";
        String url4 = "https://img1.qunarzz.com/travel/d7/1701/bb/e4df8528f2de78b5.jpg";
        String url5 = "https://youimg1.c-ctrip.com/target/fd/tg/g1/M07/3B/09/CghzfFWjP6WAO8VGAAGR1jfk6Hg938.jpg";
        imageUrls.add(url1);
        imageUrls.add(url2);
        imageUrls.add(url3);
        imageUrls.add(url4);
        imageUrls.add(url5);
        String title = "标题";
        titles.add(title);
        titles.add(title);
        titles.add(title);
        titles.add(title);
        titles.add(title);
        Banner banner = findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imageUrls);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles(titles);
        banner.isAutoPlay(true);
        banner.setDelayTime(1500);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
    }
}
