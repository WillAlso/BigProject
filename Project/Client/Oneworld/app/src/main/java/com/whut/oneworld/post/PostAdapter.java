package com.whut.oneworld.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.PostInfo;
import com.whut.oneworld.util.GlideEngine;

/**
 * RecycleView适配器，含有context引用和PostViewModel
 * context引用主要指加载列表获取内容
 * PostViewModel主要与仓库交互，并存放数据
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    // 包含着context，相当于PostFragment的Activity
    private final Context context;
    // 持有ViewModel引用，使用它完成和Model成交互
    private PostViewModel postViewModel;

    private OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClicked(View view, int postion);
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class PostHolder extends RecyclerView.ViewHolder {

        private ImageView post_image;
        private TextView post_title;
        private TextView post_author;

        public PostHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            post_image = itemView.findViewById(R.id.post_image);
            post_title = itemView.findViewById(R.id.post_title);
            post_author = itemView.findViewById(R.id.post_author);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClicked(v, position);
                        }
                    }
                }
            });
        }
    }

    public PostAdapter(Context context, PostViewModel postViewModel) {
        this.context = context;
        this.postViewModel = postViewModel;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        // 绑定
        PostInfo postInfo = postViewModel.getPostInfos().getValue().get(position);
        holder.post_title.setText(postInfo.getTitle());
        holder.post_author.setText(postInfo.getAuthor());
        // 加载网络图片，context为私有属性，第二个参数为图片地址，第三个是ImageView控件引用
        GlideEngine.createGlideEngine().loadImage(context, postInfo.getImageUrl(), holder.post_image);
    }

    @Override
    public int getItemCount() {
        // 判断是否为空在获取size，否则初始化为空时，会出现空指针
        if (postViewModel != null
                && postViewModel.getPostInfos() != null
                && postViewModel.getPostInfos().getValue() != null) {
            return postViewModel.getPostInfos().getValue().size();
        }
        return 0;
    }


}
