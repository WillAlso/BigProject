package com.whut.oneworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_personal);
    }
}
