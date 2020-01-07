package com.whut.oneworld.huajian;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.whut.oneworld.bean.ArticalInfo;

import java.util.List;

public class HuajianViewModel extends ViewModel {

    private MutableLiveData<List<ArticalInfo>> articalInfos = new MutableLiveData<>();
    private HuajianRepository repository = HuajianRepository.getInstance(this);


    public MutableLiveData<List<ArticalInfo>> getArticalInfos() {
        return articalInfos;
    }

    public void setArticalInfos(MutableLiveData<List<ArticalInfo>> articalInfos) {
        this.articalInfos = articalInfos;
    }

    public void getHotArtical() {
        repository.getHotArtical();
    }
}
