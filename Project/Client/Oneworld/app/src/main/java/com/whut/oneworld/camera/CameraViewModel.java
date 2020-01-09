package com.whut.oneworld.camera;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.jarvis.JImageClassify;

import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

public class CameraViewModel extends ViewModel {

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(3);

    private Observable<String> observable;


    public void detectPlant(String imagePath, Observer<String> observer) {
        databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                JImageClassify jImageClassify = JImageClassify.getInstance();
                JSONObject jsonObject = jImageClassify.plantDetectByImagePath(imagePath, 1);
                Gson gson = new Gson();
                String result = gson.toJson(jsonObject);
                Log.d("TESTNOW","\n" +  result + "\n");
                observable = Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> e) throws Exception {
                        e.onNext(result);
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
                observable.subscribe(observer);
            }
        });
    }

}
