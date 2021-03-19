package com.ferdinurul.mysubmissionpemula.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ferdinurul.mysubmissionpemula.R;

public class RincianActivity extends AppCompatActivity {

    TextView tv_nama_konten, tv_kategori, tv_deskripsi;
    ImageView iv_konten;

    String nama_konten, kategori, deskripsi;
    int konten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian);

        getSupportActionBar().setTitle("DETAIL KONTEN");

        nama_konten = getIntent().getStringExtra("nama_konten");
        kategori = getIntent().getStringExtra("kategori");
        deskripsi = getIntent().getStringExtra("deskripsi");
        konten = getIntent().getIntExtra("konten", 0);

        tv_nama_konten = findViewById(R.id.tv_nama_konten);
        tv_kategori = findViewById(R.id.tv_kategori);
        tv_deskripsi = findViewById(R.id.tv_deskripsi);
        iv_konten = findViewById(R.id.iv_konten);

        tv_nama_konten.setText(nama_konten);
        tv_kategori.setText(kategori);
        tv_deskripsi.setText(deskripsi);
        Glide.with(RincianActivity.this)
                .load(konten)
                .placeholder(R.drawable.ic_launcher_background)
                .into(iv_konten);
    }
}
