package com.whut.oneworld.post.postdetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.PostCommentInfo;


public class PostCommentAdapter extends RecyclerView.Adapter<PostCommentAdapter.PostCommentHolder> {

    class PostCommentHolder extends RecyclerView.ViewHolder {
        TextView post_comment_user;
        TextView post_comment_content;

        public PostCommentHolder(@NonNull View itemView) {
            super(itemView);
            post_comment_user = itemView.findViewById(R.id.post_comment_user);
            post_comment_content = itemView.findViewById(R.id.post_comment_content);
        }
    }

    private Context context;
    private PostCommentViewModel postCommentViewModel;

    public PostCommentAdapter(Context context, PostCommentViewModel postCommentViewModel) {
        this.context = context;
        this.postCommentViewModel = postCommentViewModel;
    }

    @NonNull
    @Override
    public PostCommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post_comment, parent, false);
        return new PostCommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostCommentHolder holder, int position) {
        PostCommentInfo commentInfo = postCommentViewModel.getPostCommentInfos().getValue().get(position);
        holder.post_comment_user.setText(commentInfo.getUserName());
        holder.post_comment_user.setText(commentInfo.getComment());
    }

    @Override
    public int getItemCount() {
        if (postCommentViewModel != null
                && postCommentViewModel.getPostCommentInfos() != null
                && postCommentViewModel.getPostCommentInfos().getValue() != null) {
            return postCommentViewModel.getPostCommentInfos().getValue().size();
        }
        return 0;
    }
}
