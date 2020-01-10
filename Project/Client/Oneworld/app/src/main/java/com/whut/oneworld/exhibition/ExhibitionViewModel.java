package com.whut.oneworld.exhibition;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.whut.oneworld.bean.ExhibitionInfo;

import java.util.List;

public class ExhibitionViewModel extends ViewModel {
    private MutableLiveData<List<ExhibitionInfo>> exhibitionInfos = new MutableLiveData<>();
    private ExhibitionRepository exhibitionRepository = ExhibitionRepository.getInstance(this);

    public MutableLiveData<List<ExhibitionInfo>> getExhibitionInfos() {
        return exhibitionInfos;
    }

    public void setExhibitionInfos(MutableLiveData<List<ExhibitionInfo>> exhibitionInfos) {
        this.exhibitionInfos = exhibitionInfos;
    }
    public void getAllExhibition() {exhibitionRepository.getAllPost();}
}
