package com.whut.oneworld.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.whut.oneworld.R;
import com.whut.oneworld.util.GlideEngine;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_gallery);
        PictureSelector.create(GalleryActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .isUseCustomCamera(false)
                .isOriginalImageControl(true)
                .isWeChatStyle(true)
                .isAndroidQTransform(false)
                .enableCrop(false)
                .maxSelectNum(1)
                .imageSpanCount(4)
                .isReturnEmpty(false)
                .cameraFileName("Test.png")
                .isCamera(true)
                .loadImageEngine(GlideEngine.createGlideEngine())
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }
}
