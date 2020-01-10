package com.whut.oneworld.Artical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ArticalInfo;

import java.util.List;

public class ArticalFragment extends Fragment {
    private ArticalViewModel articalViewModel;
    private RecyclerView rv_artival;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_artical,container,false);
        articalViewModel = ViewModelProviders.of(getActivity()).get(ArticalViewModel.class);
        articalViewModel.getAllArtical();
        articalViewModel.getArticalInfos().observe(this, new Observer<List<ArticalInfo>>() {
            @Override
            public void onChanged(List<ArticalInfo> articalInfos) {
                rv_artival.getAdapter().notifyDataSetChanged();
            }
        });
        rv_artival = view.findViewById(R.id.rv_artical);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_artival.setLayoutManager(layoutManager);
        ArticalAdapter articalAdapter = new ArticalAdapter(getActivity(), articalViewModel);

        rv_artival.setAdapter(articalAdapter);
        return  view;
    }
}

