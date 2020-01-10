package com.whut.oneworld.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.whut.oneworld.R;
import com.whut.oneworld.bean.detectbean.DetectBean;
import com.whut.oneworld.bean.detectbean.Value;
import com.whut.oneworld.bean.detectbean.ValueInfo;
import com.whut.oneworld.util.GlideEngine;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GalleryActivity extends AppCompatActivity {

    private final static String TAG = "MyCAMERATEST";

    private LocalMedia localMedia = null;
    private ImageView gallery_plant_image;

    private ImageView gallery_image;
    private TextView  gallery_name;
    private TextView  gallery_score;
    private TextView  gallery_desc;

    private CameraViewModel cameraViewModel;
    private Observer<String> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_gallery);

        gallery_plant_image = findViewById(R.id.gallery_plant_image);
        gallery_image = findViewById(R.id.gallery_image);
        gallery_name = findViewById(R.id.gallery_name);
        gallery_score = findViewById(R.id.gallery_score);
        gallery_desc = findViewById(R.id.gallery_desc);

        cameraViewModel = ViewModelProviders.of(this).get(CameraViewModel.class);

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Gson gson = new Gson();
                DetectBean detectBean = gson.fromJson(value, DetectBean.class);
                Value t = detectBean.getNameValuePairs().getResult().getValues().get(0);
                ValueInfo valueInfo = t.getNameValuePairs();
                String plantName = valueInfo.getName();
                String plantScore = String.valueOf(valueInfo.getScore());
                String plantImage = valueInfo.getBaike_info().getNameValuePairs().getImage_url();
                String plantDesc = valueInfo.getBaike_info().getNameValuePairs().getDescription();

                GlideEngine.createGlideEngine().loadImage(getApplicationContext(), plantImage, gallery_image);
                gallery_name.setText("植物名：" + plantName);
                gallery_score.setText("可信度：" + plantScore);
                gallery_desc.setText("描述：" + plantDesc);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        String name = String.valueOf(System.currentTimeMillis());
        PictureSelector.create(GalleryActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .isUseCustomCamera(false)
                .isOriginalImageControl(true)
                .isAndroidQTransform(false)
                .enableCrop(false)
                .maxSelectNum(1)
                .imageSpanCount(4)
                .isReturnEmpty(false)
                .isCamera(true)
                .compress(true)
                .compressQuality(60)
                .renameCompressFile(name + "_tar.png")
                .loadImageEngine(GlideEngine.createGlideEngine())
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    public void updateUIImage() {
        if (localMedia != null) {
            GlideEngine.createGlideEngine().loadImage(this, localMedia.getCompressPath(), gallery_plant_image);
            cameraViewModel.detectPlant(localMedia.getCompressPath(), observer);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                for (LocalMedia media : selectList) {
                    localMedia = media;
                    Log.i(TAG, "压缩::" + media.getCompressPath());
                    Log.i(TAG, "原图::" + media.getPath());
                    Log.i(TAG, "裁剪::" + media.getCutPath());
                    Log.i(TAG, "是否开启原图::" + media.isOriginal());
                    Log.i(TAG, "原图路径::" + media.getOriginalPath());
                    Log.i(TAG, "Android Q 特有Path::" + media.getAndroidQToPath());
                }
                break;
        }
        updateUIImage();
    }
}
