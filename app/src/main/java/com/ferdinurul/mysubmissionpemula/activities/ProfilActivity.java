package com.ferdinurul.mysubmissionpemula.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ferdinurul.mysubmissionpemula.R;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setTitle("TENTANG SAYA");
    }
}
