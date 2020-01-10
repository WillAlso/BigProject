package com.whut.oneworld.exhibition.exhibitiondetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whut.oneworld.R;
import com.whut.oneworld.bean.ExhibitionCommentInfo;
import com.whut.oneworld.bean.ExhibitionInfo;
import com.whut.oneworld.exhibition.ExhibitionAdapter;

import java.util.List;

public class ExhibitionCommentAdapter extends RecyclerView.Adapter<ExhibitionCommentAdapter.ExhibitionCommentHolder> {

    class ExhibitionCommentHolder extends RecyclerView.ViewHolder {
        TextView exhibition_comment_user;
        TextView exhibition_comment_content;

        public ExhibitionCommentHolder(@NonNull View itemView) {
            super(itemView);
            exhibition_comment_user = itemView.findViewById(R.id.exhibition_comment_user);
            exhibition_comment_content = itemView.findViewById(R.id.exhibition_comment_content);
        }
    }

    private Context context;
    private  ExhibitionCommentViewModel exhibitionCommentViewModel;

    public ExhibitionCommentAdapter(Context context, ExhibitionCommentViewModel exhibitionCommentViewModel) {
        this.context = context;
        this.exhibitionCommentViewModel = exhibitionCommentViewModel;
    }
    @NonNull
    @Override
    public ExhibitionCommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_exhibition_comment, parent, false);
        return new ExhibitionCommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitionCommentHolder holder, int position) {
        ExhibitionCommentInfo commentInfo = exhibitionCommentViewModel.getExhibitionCommentInfos().getValue().get(position);
        holder.exhibition_comment_user.setText(commentInfo.getUserName());
        holder.exhibition_comment_content.setText(commentInfo.getComment());
    }

    @Override
    public int getItemCount() {
        if (exhibitionCommentViewModel != null
        && exhibitionCommentViewModel.getExhibitionCommentInfos() != null
        && exhibitionCommentViewModel.getExhibitionCommentInfos().getValue() != null) {
            return exhibitionCommentViewModel.getExhibitionCommentInfos().getValue().size();
        }
        return 0;
    }
}
