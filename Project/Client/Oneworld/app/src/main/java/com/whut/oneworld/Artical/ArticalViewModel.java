package com.whut.oneworld.Artical;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.whut.oneworld.bean.ArticalInfo;

import java.util.List;

public class ArticalViewModel extends ViewModel {
    private MutableLiveData<List<ArticalInfo>>  articalInfos = new MutableLiveData<>();
    private ArticalRepository articalRepository = ArticalRepository.getInstance(this);

    public MutableLiveData<List<ArticalInfo>> getArticalInfos() {
        return articalInfos;
    }

    public void setArticalInfos(MutableLiveData<List<ArticalInfo>> articalInfos) {
        this.articalInfos = articalInfos;
    }

    public void getAllArtical() {articalRepository.getAllArtical();}

}
