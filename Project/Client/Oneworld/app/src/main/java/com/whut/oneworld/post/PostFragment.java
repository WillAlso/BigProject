package com.whut.oneworld.post;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.whut.oneworld.MainActivity;
import com.whut.oneworld.R;
import com.whut.oneworld.bean.PostInfo;
import com.whut.oneworld.post.postdetail.PostDeatilActivity;

import org.greenrobot.eventbus.EventBus;

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
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv_post.setLayoutManager(layoutManager);
        PostAdapter postAdapter = new PostAdapter(getActivity(), postViewModel);
        postAdapter.setClickListener(new PostAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(View view, int postion) {
                PostInfo postInfo = postViewModel.getPostInfos().getValue().get(postion);

                EventBus.getDefault().postSticky(postInfo);
                Intent intent = new Intent(getActivity(), PostDeatilActivity.class);
                startActivity(intent);
            }
        });

        rv_post.setAdapter(postAdapter);

        return view;
    }
}
