package com.example.mobile_ta_b12;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ListMahasiswaActivity extends AppCompatActivity {
    private RecyclerView listmhs;
    private ArrayList<ListMahasiswa> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listmhs = findViewById(R.id.recycleview_listmahasiswa);
        listmhs.setHasFixedSize(true);

        list.addAll(getListMahasiswaa());
        showRecyclerList();
    }

    private void showRecyclerList() {
        listmhs.setLayoutManager(new LinearLayoutManager(this));
        ListMahasiswaAdapter listHeroAdapter = new ListMahasiswaAdapter(list);
        listmhs.setAdapter(listHeroAdapter);
    }

    public ArrayList<ListMahasiswa> getListMahasiswaa() {
        String[] nama_mahasiswa = getResources().getStringArray(R.array.nama_mahasiswa);
        String[] nim_mahasiswa = getResources().getStringArray(R.array.nim_mahasiswa);
        ArrayList<ListMahasiswa> listMahasiswab = new ArrayList<>();
        for (int i = 0; i < nama_mahasiswa.length; i++) {
            ListMahasiswa listMahasiswa = new ListMahasiswa();
            listMahasiswa.setNama_mahasiswa(nama_mahasiswa[i]);
            listMahasiswa.setNim_peserta(nim_mahasiswa[i]);
            listMahasiswab.add(listMahasiswa);
        }
        return listMahasiswab;
    }

    public void profile(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, ProfileActivity.class);
        startActivity(intent);

//    public void tambahLB(View view) {
//        Intent intent = new Intent(LogbookActivity.this,AddlogbookActivity.class);
//        startActivity(intent);
//    }
    }
}