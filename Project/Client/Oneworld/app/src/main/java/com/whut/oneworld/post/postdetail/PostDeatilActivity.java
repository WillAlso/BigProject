package com.whut.oneworld.post.postdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.PostCommentInfo;
import com.whut.oneworld.bean.PostInfo;
import com.whut.oneworld.util.GlideEngine;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class PostDeatilActivity extends AppCompatActivity {

    private PostCommentViewModel postCommentViewModel;
    private RecyclerView recyclerView;
    private PostCommentAdapter adapter;

    private ImageView post_detail_image;
    private TextView post_detail_title;
    private TextView post_detail_author;

    private EditText post_edit_comment;
    private Button send_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_post_deatil);


        post_detail_image = findViewById(R.id.post_detail_image);
        post_detail_title = findViewById(R.id.post_detail_title);
        post_detail_author = findViewById(R.id.post_detail_author);
        recyclerView = findViewById(R.id.post_detail_comment);
        send_comment = findViewById(R.id.send_comment);
        post_edit_comment = findViewById(R.id.post_edit_comment);

        send_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = post_edit_comment.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    Toast.makeText(getApplicationContext(), "评论不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });

        postCommentViewModel = ViewModelProviders.of(this).get(PostCommentViewModel.class);

        postCommentViewModel.getPostInfo().observe(this, new Observer<PostInfo>() {
            @Override
            public void onChanged(PostInfo postInfo) {
                post_detail_title.setText(postInfo.getTitle());
                post_detail_author.setText(postInfo.getAuthor());
                GlideEngine.createGlideEngine().loadImage(getApplicationContext(), postInfo.getImageUrl(), post_detail_image);
                postCommentViewModel.getPostComment();
            }
        });

        postCommentViewModel.getPostCommentInfos().observe(this, new Observer<List<PostCommentInfo>>() {
            @Override
            public void onChanged(List<PostCommentInfo> postCommentInfos) {
                Toast.makeText(getApplicationContext(), "得到", Toast.LENGTH_SHORT).show();
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostCommentAdapter(this, postCommentViewModel);
        recyclerView.setAdapter(adapter);

        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventPost(PostInfo postInfo) {
        postCommentViewModel.getPostInfo().setValue(postInfo);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
