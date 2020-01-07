package com.whut.oneworld.huajian;

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

import java.util.List;

public class HuajianAdapter extends RecyclerView.Adapter<HuajianAdapter.HuajianHolder> {

    private Context context;
    private HuajianViewModel huajianViewModel;

    public HuajianAdapter(Context context, HuajianViewModel huajianViewModel) {
        this.context = context;
        this.huajianViewModel = huajianViewModel;
    }


    @NonNull
    @Override
    public HuajianHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_huajian, parent, false);
        return new HuajianHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HuajianHolder holder, int position) {
        ArticalInfo articalInfo = huajianViewModel.getArticalInfos().getValue().get(position);
        holder.title_view.setText(articalInfo.getTitle());
        holder.author_view.setText(articalInfo.getAuthor());
        holder.description_view.setText(articalInfo.getDescription());
        GlideEngine.createGlideEngine().loadImage(context, articalInfo.getImageUrl(), holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (huajianViewModel != null
                && huajianViewModel.getArticalInfos() != null
                && huajianViewModel.getArticalInfos().getValue() != null) {
            return huajianViewModel.getArticalInfos().getValue().size();
        }
        return 0;
    }

    class HuajianHolder extends RecyclerView.ViewHolder {
        private TextView title_view;
        private TextView description_view;
        private TextView author_view;
        private ImageView imageView;
        public HuajianHolder(@NonNull View itemView) {
            super(itemView);
            title_view = itemView.findViewById(R.id.huajian_title);
            description_view = itemView.findViewById(R.id.huajian_description);
            author_view = itemView.findViewById(R.id.huajian_author);
            imageView = itemView.findViewById(R.id.huajian_image);
        }
    }

}
