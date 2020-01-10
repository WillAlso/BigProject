package com.whut.oneworld.Artical;

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
import com.whut.oneworld.exhibition.ExhibitionAdapter;
import com.whut.oneworld.util.GlideEngine;

public class ArticalAdapter extends RecyclerView.Adapter<ArticalAdapter.ArticalHolder> {
    private final Context context;
    private ArticalViewModel articalViewModel;

    private OnItemClickListener clickListener;
    public interface OnItemClickListener {
        void onItemClicked(View view, int position);
    }
    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ArticalHolder extends RecyclerView.ViewHolder {
        private ImageView artical_image;
        private TextView artical_author;
        private TextView artical_title;
        private TextView artical_description;
        private TextView artical_artical;

        public ArticalHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);
            artical_image = itemView.findViewById(R.id.artical_image);
            artical_title = itemView.findViewById(R.id.artical_title);
            artical_description = itemView.findViewById(R.id.artical_description);
            artical_author = itemView.findViewById(R.id.artical_author);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener !=null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClicked(v, position);
                        }
                    }
                }
            });

        }
    }
    public ArticalAdapter(Context context,ArticalViewModel articalViewModel) {
        this.context = context;
        this.articalViewModel = articalViewModel;
    }
    @NonNull
    @Override
    public ArticalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_artical, parent, false);
        return new ArticalHolder(view,clickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ArticalHolder holder, int position) {
        ArticalInfo articalInfo = articalViewModel.getArticalInfos().getValue().get(position);
        holder.artical_title.setText(articalInfo.getTitle());
        holder.artical_description.setText(articalInfo.getDescription());
        holder.artical_author.setText(articalInfo.getAuthor());
        GlideEngine.createGlideEngine().loadImage(context,articalInfo.getImageUrl(), holder.artical_image);
    }
    @Override
    public int getItemCount(){
        if(articalViewModel != null
        && articalViewModel.getArticalInfos() != null
        && articalViewModel.getArticalInfos().getValue() != null) {
            return articalViewModel.getArticalInfos().getValue().size();
        }
        return 0;
    }
}
