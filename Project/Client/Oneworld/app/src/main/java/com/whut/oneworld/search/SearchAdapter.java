package com.whut.oneworld.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.util.GlideEngine;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

    private Context context;
    private TagViewModel tagViewModel;

    private SearchAdapter.OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClicked(View view, int postion);
    }

    public void setClickListener(SearchAdapter.OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    class SearchHolder extends RecyclerView.ViewHolder {
        ImageView search_image;
        TextView search_title;
        TextView search_author;
        TextView search_time;

        public SearchHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            search_image = itemView.findViewById(R.id.search_image);
            search_title = itemView.findViewById(R.id.search_title);
            search_author = itemView.findViewById(R.id.search_author);
            search_time = itemView.findViewById(R.id.search_time);
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

    public SearchAdapter(Context context, TagViewModel tagViewModel) {
        this.context = context;
        this.tagViewModel = tagViewModel;
    }

    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false);
        return new SearchHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        ArticalInfo articalInfo = tagViewModel.getArticalInfos().getValue().get(position);
        holder.search_author.setText(articalInfo.getAuthor());
        holder.search_title.setText(articalInfo.getTitle());
        holder.search_time.setText(String.valueOf(articalInfo.getPubDate()));
        GlideEngine.createGlideEngine().loadImage(context, articalInfo.getImageUrl(), holder.search_image);
    }

    @Override
    public int getItemCount() {
        if (tagViewModel != null
                && tagViewModel.getArticalInfos() != null
                && tagViewModel.getArticalInfos().getValue() != null) {
            return tagViewModel.getArticalInfos().getValue().size();
        }
        return 0;
    }
}
