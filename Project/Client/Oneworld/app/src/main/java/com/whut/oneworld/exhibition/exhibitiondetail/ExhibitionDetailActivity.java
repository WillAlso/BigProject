package com.whut.oneworld.exhibition.exhibitiondetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ExhibitionCommentInfo;
import com.whut.oneworld.bean.ExhibitionInfo;
import com.whut.oneworld.util.GlideEngine;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ExhibitionDetailActivity extends AppCompatActivity {
    private ExhibitionCommentViewModel exhibitionCommentViewModel;
    private RecyclerView recyclerView;
    private ExhibitionCommentAdapter adapter;

    private ImageView exhibition_detail_image;
    private TextView exhibition_detail_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_exhibition_detail);

        exhibition_detail_image = findViewById(R.id.exhibition_detail_image);
        exhibition_detail_title = findViewById(R.id.exhibition_detail_title);
        recyclerView = findViewById(R.id.exhibition_detail_comment);

        exhibitionCommentViewModel = ViewModelProviders.of(this).get(ExhibitionCommentViewModel.class);

        exhibitionCommentViewModel.getExhibitionInfo().observe(this, new Observer<ExhibitionInfo>() {
            @Override
            public void onChanged(ExhibitionInfo exhibitionInfo) {
                exhibition_detail_title.setText(exhibitionInfo.getTitle());
                GlideEngine.createGlideEngine().loadImage(getApplicationContext(), exhibitionInfo.getImageUrl(), exhibition_detail_image);
                exhibitionCommentViewModel.getExhibitionComment();
            }
        });
        exhibitionCommentViewModel.getExhibitionCommentInfos().observe(this, new Observer<List<ExhibitionCommentInfo>>() {
            @Override
            public void onChanged(List<ExhibitionCommentInfo> exhibitionCommentInfos) {
                Toast.makeText(getApplicationContext(), "得到", Toast.LENGTH_SHORT).show();
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ExhibitionCommentAdapter(this,exhibitionCommentViewModel);
        recyclerView.setAdapter(adapter);

        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvenExhibition(ExhibitionInfo exhibitionInfo) {
        exhibitionCommentViewModel.getExhibitionInfo().setValue(exhibitionInfo);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
