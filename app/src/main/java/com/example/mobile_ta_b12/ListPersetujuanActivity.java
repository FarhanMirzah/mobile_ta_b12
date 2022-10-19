package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.adapter.ListMahasiswaAdapter;
import com.example.mobile_ta_b12.models.ListMahasiswa;

import java.util.ArrayList;

public class ListPersetujuanActivity extends AppCompatActivity {
    private RecyclerView listmhs;
    private ArrayList<ListMahasiswa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persetujuan);

        listmhs = findViewById(R.id.recyclerview_persetujuan);
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

    public void arrowBack(View view) {
        Intent profileIntent = new Intent(this, ListMahasiswaActivity.class);
        startActivity(profileIntent);
    }
}