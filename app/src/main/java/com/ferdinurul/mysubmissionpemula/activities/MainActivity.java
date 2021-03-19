package com.ferdinurul.mysubmissionpemula.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ferdinurul.mysubmissionpemula.R;
import com.ferdinurul.mysubmissionpemula.adapters.ListDataAdapter;
import com.ferdinurul.mysubmissionpemula.models.Data;
import com.ferdinurul.mysubmissionpemula.models.ModelData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ModelData> mArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.potensi_title);

        recyclerView = findViewById(R.id.rv_data);
        recyclerView.setHasFixedSize(true);

        mArrayList.addAll(Data.getDataList());

        showListData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profil, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(menuItem);
    }

    private void showListData(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListDataAdapter listDataAdapter = new ListDataAdapter(getApplicationContext(), mArrayList);
        recyclerView.setAdapter(listDataAdapter);

        listDataAdapter.setOnItemClickCallback(new ListDataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelData data) {
                showSelectedItem(data);
            }
        });
    }

    private void showSelectedItem(ModelData data) {
        String nama_konten = data.getNama_konten();
        String kategori = data.getKategori();
        int konten = data.getKonten();
        String deskripsi = data.getDeskripsi();

        Intent intent = new Intent(this, RincianActivity.class);
        intent.putExtra("nama_konten", nama_konten);
        intent.putExtra("kategori", kategori);
        intent.putExtra("konten", konten);
        intent.putExtra("deskripsi", deskripsi);
        this.startActivity(intent);
    }
}
