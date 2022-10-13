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

    public void buttonButuhPersetujuan(View view) {
        Intent butuhPersetujuanIntent = new Intent(this, ListPersetujuanActivity.class);
        startActivity(butuhPersetujuanIntent);
    }

    public void buttonListJadwal(View view) {
        Intent listJadwalIntent = new Intent(this, ListJadwalActivity.class);
        startActivity(listJadwalIntent);
    }
}