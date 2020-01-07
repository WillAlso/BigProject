package com.whut.oneworld.huajian;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ArticalInfo;

import java.util.ArrayList;
import java.util.List;

public class HuajianFragment extends Fragment {

    private HuajianViewModel huajianViewModel;
    private RecyclerView rv_huajian;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.huajian_fragment,container,false);

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

        return  view;
    }
}
