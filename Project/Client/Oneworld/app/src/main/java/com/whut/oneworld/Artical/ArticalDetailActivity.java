package com.whut.oneworld.Artical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.util.GlideEngine;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ArticalDetailActivity extends AppCompatActivity {
    private ImageView artical_detail_image;
    private TextView artical_detail_author;
    private TextView artical_detail_title;
    private TextView artical_detail_description;
    private WebView artical_detail_artical;//文章文字内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_artical_detail);

        artical_detail_image = findViewById(R.id.artical_detail_image);
        artical_detail_title = findViewById(R.id.artical_detail_title);
        artical_detail_description = findViewById(R.id.artical_detail_description);
        artical_detail_author = findViewById(R.id.artical_detail_author);
        artical_detail_artical = findViewById(R.id.artical_detail_artical);

        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventArtical(ArticalInfo articalInfo) {
        GlideEngine.createGlideEngine().loadImage(getApplicationContext(), articalInfo.getImageUrl(), artical_detail_image);
        artical_detail_title.setText(articalInfo.getTitle());
        artical_detail_description.setText(articalInfo.getDescription());
        artical_detail_author.setText(articalInfo.getAuthor());
        //加载文章,
        artical_detail_artical.loadUrl(articalInfo.getArticalUrl());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
