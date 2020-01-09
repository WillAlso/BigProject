package com.whut.oneworld.exhibition.exhibitiondetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.whut.oneworld.bean.ExhibitionCommentInfo;
import com.whut.oneworld.bean.ExhibitionInfo;

import java.util.List;

public class ExhibitionCommentViewModel extends ViewModel {
    private ExhibitionCommentRepository exhibitionCommentRepository = ExhibitionCommentRepository.getInstance(this);
    private MutableLiveData<List<ExhibitionCommentInfo>> exhibitionCommentInfos = new MutableLiveData<>();
    private MutableLiveData<ExhibitionInfo> exhibitionInfo = new MutableLiveData<>();

    public MutableLiveData<List<ExhibitionCommentInfo>> getExhibitionCommentInfos() {return exhibitionCommentInfos;}
    public void setExhibitionCommentInfos(MutableLiveData<List<ExhibitionCommentInfo>> exhibitionCommentInfos) {
        this.exhibitionCommentInfos = exhibitionCommentInfos;
    }
    public MutableLiveData<ExhibitionInfo> getExhibitionInfo() {return exhibitionInfo;}
    public void setExhibitionInfo(MutableLiveData<ExhibitionInfo> exhibitionInfo) {this.exhibitionInfo = exhibitionInfo;}
    public void getExhibitionComment() {
        exhibitionCommentRepository.getExhibitionComment(exhibitionInfo.getValue().getExhibitionNum());
    }
    public ExhibitionCommentRepository getExhibitionCommentRepository() {return exhibitionCommentRepository;}
    public void setExhibitionCommentRepository(ExhibitionCommentRepository exhibitionCommentRepository) {
        this.exhibitionCommentRepository = exhibitionCommentRepository;
    }
}
