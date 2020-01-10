package com.whut.oneworld.search;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.whut.oneworld.bean.ArticalInfo;
import com.whut.oneworld.bean.TagInfo;

import java.util.List;

public class TagViewModel extends AndroidViewModel {

    private TagRepository repository;

    private LiveData<List<TagInfo>> tagInfos;
    private MutableLiveData<List<ArticalInfo>> articalInfos = new MutableLiveData<>();
    private Application application;

    public TagViewModel(Application application) {
        super(application);
        repository = new TagRepository(application, this);
        tagInfos = repository.getAllTagInfo();
        List<TagInfo> tagInfoList = tagInfos.getValue();
    }

    LiveData<List<TagInfo>> getAllTag() {
        return tagInfos;
    }

    public MutableLiveData<List<ArticalInfo>> getArticalInfos() {
        return articalInfos;
    }

    public void setArticalInfos(MutableLiveData<List<ArticalInfo>> articalInfos) {
        this.articalInfos = articalInfos;
    }

    public void insert(TagInfo tagInfo) {
        repository.insert(tagInfo);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteTag(TagInfo tagInfo) {
        repository.deleteTag(tagInfo);
    }

    public void getSearchArtical(String title) {
        repository.getSearchArtical(title);
    }

    public void showError() {

    }
}
