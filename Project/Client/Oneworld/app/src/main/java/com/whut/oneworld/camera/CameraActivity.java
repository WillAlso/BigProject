package com.whut.oneworld.camera;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.whut.oneworld.R;
import com.whut.oneworld.util.GlideEngine;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        PictureSelector.create(CameraActivity.this)
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

//        PictureSelector.create(this)
//                .openCamera(PictureMimeType.ofImage())
//                .loadImageEngine(GlideEngine.createGlideEngine())
//                .forResult(PictureConfig.REQUEST_CAMERA);
    }
}
