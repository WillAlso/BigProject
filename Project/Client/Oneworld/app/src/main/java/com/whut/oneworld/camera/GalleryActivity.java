package com.whut.oneworld.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.whut.oneworld.R;
import com.whut.oneworld.util.GlideEngine;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GalleryActivity extends AppCompatActivity {

    private final static String TAG = "MyCAMERATEST";

    private LocalMedia localMedia = null;
    private ImageView gallery_plant_image;
    private TextView gallery_plant_info;

    private CameraViewModel cameraViewModel;
    private Observer<String> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_gallery);

        gallery_plant_image = findViewById(R.id.gallery_plant_image);
        gallery_plant_info = findViewById(R.id.gallery_plant_info);

        cameraViewModel = ViewModelProviders.of(this).get(CameraViewModel.class);

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.d("MAINTHREAD", value);
                gallery_plant_info.setText(value);
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
