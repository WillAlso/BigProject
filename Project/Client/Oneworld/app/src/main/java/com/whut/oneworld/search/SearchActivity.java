package com.whut.oneworld.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.whut.oneworld.R;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        TagContainerLayout containerLayout = findViewById(R.id.search_tag);
        List<String> tags = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            tags.add("标签" + i);
        }
        containerLayout.setTags(tags);
    }
}
