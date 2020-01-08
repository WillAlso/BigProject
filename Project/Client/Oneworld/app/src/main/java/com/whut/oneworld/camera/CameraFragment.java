package com.whut.oneworld.camera;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.jarvis.JImageClassify;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;


import com.whut.oneworld.R;
import com.whut.oneworld.util.GlideEngine;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CameraFragment extends Fragment {

    private final static String TAG = "MyCAMERATEST";

    private LocalMedia localMedia = null;
    private ImageView camera_plant_image;
    private TextView camera_plant_info;

    private CameraViewModel cameraViewModel;
    private Observer<String> observer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        camera_plant_image = view.findViewById(R.id.camera_plant_image);
        camera_plant_info = view.findViewById(R.id.camera_plant_info);

        cameraViewModel = ViewModelProviders.of(getActivity()).get(CameraViewModel.class);

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.d("MAINTHREAD", value);
                camera_plant_info.setText(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        String name = String.valueOf(System.currentTimeMillis());
        PictureSelector.create(CameraFragment.this)
                .openCamera(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine())
                .isOriginalImageControl(true)
                .cameraFileName(name + ".png")
                .renameCompressFile(name + "_tar.png")
                .imageFormat(PictureMimeType.PNG)
                .compress(true)
                .compressQuality(60)
                .forResult(PictureConfig.REQUEST_CAMERA);
        return view;
    }

    public void updateUIImage() {
        if (localMedia != null) {
            GlideEngine.createGlideEngine().loadImage(getActivity(), localMedia.getCompressPath(), camera_plant_image);
            cameraViewModel.detectPlant(localMedia.getCompressPath(), observer);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.REQUEST_CAMERA:
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
