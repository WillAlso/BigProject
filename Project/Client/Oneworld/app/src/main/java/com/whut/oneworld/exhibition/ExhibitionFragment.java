package com.whut.oneworld.exhibition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ExhibitionInfo;

import java.util.List;

public class ExhibitionFragment extends Fragment {
    private ExhibitionViewModel exhibitionViewModel;
    private RecyclerView rv_exhibition;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exhibition, container, false);
        exhibitionViewModel = ViewModelProviders.of(getActivity()).get(ExhibitionViewModel.class);
        exhibitionViewModel.getAllExhibition();
        exhibitionViewModel.getExhibitionInfos().observe(this, new Observer<List<ExhibitionInfo>>() {
            @Override
            public void onChanged(List<ExhibitionInfo> exhibitionInfos) {
                rv_exhibition.getAdapter().notifyDataSetChanged();
            }
        });
        rv_exhibition = view.findViewById(R.id.rv_exhibition);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_exhibition.setLayoutManager(layoutManager);
        ExhibitionAdapter exhibitionAdapter = new ExhibitionAdapter(getActivity(), exhibitionViewModel);
        rv_exhibition.setAdapter(exhibitionAdapter);
        return view;
    }
}
