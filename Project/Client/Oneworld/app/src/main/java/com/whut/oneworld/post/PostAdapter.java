package com.whut.oneworld.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private final Context context;
    private final List<String> data;

    public class PostHolder extends RecyclerView.ViewHolder {
//        https://blog.csdn.net/qq_33275597/article/details/81227863
//        https://blog.csdn.net/weixin_43890904/article/details/94780084
//        https://www.jianshu.com/p/4e142909b824
        private final TextView textView;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_post);
        }
    }

    public PostAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        String bean = data.get(position);
        holder.textView.setText(bean);
    }

    @Override
    public int getItemCount() {
        if (this.data != null) {
            return data.size();
        }
        return 0;
    }
}
