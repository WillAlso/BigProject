package com.whut.oneworld.search;

import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.bean.TagInfo;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;
import io.reactivex.Observable;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private TagViewModel tagViewModel;
    private RecyclerView search_result;
    private TextView delete_all_tags;
    private List<String> tags = new ArrayList<>();
    private TagContainerLayout containerLayout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_search);

        tagViewModel = ViewModelProviders.of(this).get(TagViewModel.class);

        searchView = findViewById(R.id.search_plant);
        delete_all_tags = findViewById(R.id.delete_all_tags);
        search_result = findViewById(R.id.search_result);
        containerLayout = findViewById(R.id.search_tag);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        search_result.setLayoutManager(layoutManager);
        SearchAdapter adapter = new SearchAdapter(this, tagViewModel);
        adapter.setClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(View view, int postion) {
                ArticalInfo articalInfo = tagViewModel.getArticalInfos().getValue().get(postion);


            }
        });
        search_result.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tagViewModel.insert(new TagInfo(query));
                tagViewModel.getSearchArtical(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        tagViewModel.getArticalInfos().observe(this, new Observer<List<ArticalInfo>>() {
            @Override
            public void onChanged(List<ArticalInfo> articalInfos) {
                if (articalInfos != null || articalInfos.size() > 0) {
                    tags.clear();
                    containerLayout.setTags(tags);
                    delete_all_tags.setText("");
                }
                search_result.getAdapter().notifyDataSetChanged();
            }
        });

        delete_all_tags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagViewModel.deleteAll();
                delete_all_tags.setText("");
            }
        });


        tagViewModel.getAllTag().observe(this, new Observer<List<TagInfo>>() {
            @Override
            public void onChanged(List<TagInfo> tagInfos) {
                tags.clear();
                for (TagInfo tagInfo : tagInfos) {
                    tags.add(tagInfo.getTag());
                }
                if (tagInfos.size() > 0) {
                    delete_all_tags.setText("清空历史");
                }
                containerLayout.setTags(tags);
            }
        });
        containerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                searchView.setQuery(text, false);
            }

            @Override
            public void onTagLongClick(int position, String text) {
                TagInfo tagInfo = new TagInfo(text);
                tagViewModel.deleteTag(tagInfo);
                Toast.makeText(getApplicationContext(), "删除" + text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
