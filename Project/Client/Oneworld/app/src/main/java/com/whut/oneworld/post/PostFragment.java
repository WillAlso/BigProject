package com.whut.oneworld.post;

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
import com.whut.oneworld.bean.PostInfo;

import java.util.List;

public class PostFragment extends Fragment {

    private PostViewModel postViewModel;
    private RecyclerView rv_post;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        postViewModel = ViewModelProviders.of(getActivity()).get(PostViewModel.class);
        postViewModel.getAllPost();
        postViewModel.getPostInfos().observe(this, new Observer<List<PostInfo>>() {
            @Override
            public void onChanged(List<PostInfo> postInfos) {
                rv_post.getAdapter().notifyDataSetChanged();
            }
        });
        rv_post = view.findViewById(R.id.rv_post);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rv_post.setLayoutManager(layoutManager);
        PostAdapter postAdapter = new PostAdapter(getActivity(), postViewModel);
        rv_post.setAdapter(postAdapter);

        return view;
    }
}
