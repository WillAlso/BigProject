package com.whut.oneworld.Artical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ArticalInfo;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ArticalActivity extends AppCompatActivity {
    private ArticalViewModel articalViewModel;
    private RecyclerView rv_artical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_artical);
        articalViewModel = ViewModelProviders.of(this).get(ArticalViewModel.class);
        articalViewModel.getAllArtical();
        articalViewModel.getArticalInfos().observe(this, new Observer<List<ArticalInfo>>() {
            @Override
            public void onChanged(List<ArticalInfo> articalInfos) {
                rv_artical.getAdapter().notifyDataSetChanged();
            }
        });
        rv_artical = findViewById(R.id.rv_artical);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_artical.setLayoutManager(layoutManager);
        ArticalAdapter articalAdapter = new ArticalAdapter(this, articalViewModel);
        articalAdapter.setClickListener(new ArticalAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                ArticalInfo articalInfo = articalViewModel.getArticalInfos().getValue().get(position);
                EventBus.getDefault().postSticky(articalInfo);
                Intent intent = new Intent(getApplication(), ArticalDetailActivity.class);
                startActivity(intent);
            }
        });

        rv_artical.setAdapter(articalAdapter);
    }
}
