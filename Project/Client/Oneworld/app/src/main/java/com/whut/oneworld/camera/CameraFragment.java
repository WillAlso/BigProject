package com.whut.oneworld.camera;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;


import com.whut.oneworld.R;
import com.whut.oneworld.util.GlideEngine;

import java.util.List;



public class CameraFragment extends Fragment {

    private final static String TAG = "MyCAMERATEST";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        PictureSelector.create(CameraFragment.this)
                .openCamera(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine())
                .isOriginalImageControl(true)
                .cameraFileName("test1.png")
                .renameCompressFile("test2.png")
                .imageFormat(PictureMimeType.PNG)
                .compress(true)
                .forResult(PictureConfig.REQUEST_CAMERA);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.REQUEST_CAMERA:
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                Toast.makeText(getActivity(), String.valueOf(selectList.size()) + "Hello", Toast.LENGTH_SHORT).show();
                for (LocalMedia media : selectList) {
                    Log.i(TAG, "压缩::" + media.getCompressPath());
                    Log.i(TAG, "原图::" + media.getPath());
                    Log.i(TAG, "裁剪::" + media.getCutPath());
                    Log.i(TAG, "是否开启原图::" + media.isOriginal());
                    Log.i(TAG, "原图路径::" + media.getOriginalPath());
                    Log.i(TAG, "Android Q 特有Path::" + media.getAndroidQToPath());
                }
                break;
        }
    }
}
