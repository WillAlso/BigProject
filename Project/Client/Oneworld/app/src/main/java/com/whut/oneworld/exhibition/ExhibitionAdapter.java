package com.whut.oneworld.exhibition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ExhibitionInfo;
import com.whut.oneworld.util.GlideEngine;

import java.util.List;

public class ExhibitionAdapter extends RecyclerView.Adapter<ExhibitionAdapter.ExhibitionHolder> {
    private final Context context;
    private ExhibitionViewModel exhibitionViewModel;

    public class ExhibitionHolder extends RecyclerView.ViewHolder {
        private ImageView exhibition_image;
        private TextView exhibition_title;
        private TextView exhibition_description;

        public ExhibitionHolder(@NonNull View itemView) {
            super(itemView);
            exhibition_image = itemView.findViewById(R.id.exhibition_image);
            exhibition_title = itemView.findViewById(R.id.exhibition_title);
            exhibition_description = itemView.findViewById(R.id.exhibition_description);
        }
    }

    public ExhibitionAdapter(Context context, ExhibitionViewModel exhibitionViewModel) {
        this.context = context;
        this.exhibitionViewModel = exhibitionViewModel;
    }

    @NonNull
    @Override
    public ExhibitionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_exhibition, parent, false);
        return new ExhibitionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitionHolder holder, int position) {
        ExhibitionInfo exhibitionInfo = exhibitionViewModel.getExhibitionInfos().getValue().get(position);
        holder.exhibition_title.setText(exhibitionInfo.getTitle());
        holder.exhibition_description.setText(exhibitionInfo.getDescription());
        GlideEngine.createGlideEngine().loadImage(context, exhibitionInfo.getImageUrl(), holder.exhibition_image);
    }

    @Override
    public int getItemCount() {
        if(exhibitionViewModel != null
        && exhibitionViewModel.getExhibitionInfos() != null
        && exhibitionViewModel.getExhibitionInfos().getValue() != null) {
            return  exhibitionViewModel.getExhibitionInfos().getValue().size();
        }
        return 0;
    }
}

