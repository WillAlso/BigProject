package com.whut.oneworld.huajian;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.search.SearchActivity;

import java.util.List;

public class HuajianFragment extends Fragment {

    private HuajianViewModel huajianViewModel;
    private RecyclerView rv_huajian;
    private ImageView image_search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_huajian,container,false);

        huajianViewModel = ViewModelProviders.of(getActivity()).get(HuajianViewModel.class);
        huajianViewModel.getHotArtical();
        huajianViewModel.getArticalInfos().observe(this, new Observer<List<ArticalInfo>>() {
            @Override
            public void onChanged(List<ArticalInfo> articalInfos) {
                rv_huajian.getAdapter().notifyDataSetChanged();
            }
        });

        rv_huajian = view.findViewById(R.id.rv_huajian_artical);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv_huajian.setLayoutManager(layoutManager);
        HuajianAdapter adapter = new HuajianAdapter(getActivity(), huajianViewModel);
        rv_huajian.setAdapter(adapter);

        image_search = view.findViewById(R.id.image_search);
        image_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        return  view;
    }
}
