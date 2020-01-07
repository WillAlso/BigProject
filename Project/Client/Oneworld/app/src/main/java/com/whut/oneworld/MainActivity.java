package com.whut.oneworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.whut.oneworld.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // banner images url
    private List<String> imageUrls = new ArrayList<>();
    private List<String> imageTitles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//dddfdsd
        // use banner viewpagger
        initImage();
        Banner banner = findViewById(R.id.ad_banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imageUrls);
        banner.setBannerAnimation(Transformer.Default);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();


    }

    private void initImage() {
        String url1 = "http://photo.youngfool.top:81/test/test1.jpg";
        String url2 = "http://photo.youngfool.top:81/test/test2.jpg";
        String url3 = "http://photo.youngfool.top:81/test/test3.jpg";
        String url4 = "http://photo.youngfool.top:81/test/test4.jpg";
        String url5 = "http://photo.youngfool.top:81/test/test5.jpg";
        imageUrls.add(url1);
        imageUrls.add(url2);
        imageUrls.add(url3);
        imageUrls.add(url4);
        imageUrls.add(url5);
    }
}
