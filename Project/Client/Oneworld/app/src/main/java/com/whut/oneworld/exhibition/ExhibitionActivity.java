package com.whut.oneworld.exhibition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.whut.oneworld.R;

import org.greenrobot.eventbus.EventBus;

public class ExhibitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition);
    }
}
