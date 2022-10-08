package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.adapter.ListJadwalAdapter;
import com.example.mobile_ta_b12.models.ListJadwal;

import java.util.ArrayList;

public class ListJadwalActivity extends AppCompatActivity {

     private RecyclerView rvJadwal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal);

        rvJadwal =findViewById(R.id.rvJadwal);

        ListJadwalAdapter adapter = new ListJadwalAdapter(getListJadwal());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvJadwal.setLayoutManager(layoutManager);
        rvJadwal.setAdapter(adapter);
    }


    public ArrayList<ListJadwal> getListJadwal(){
        ArrayList<ListJadwal> ListJadwal = new ArrayList<>();
        ListJadwal.add(new ListJadwal(
                null,
                1,
                "Jumat, 07 Oktober 2022",
                "09.00-12.00",
                "Ruang Sidang JSI"

        ));
        ListJadwal.add(new ListJadwal(
                null,
                0,
                "Jumat, 10 Oktober 2022",
                "10.00-12.00",
                "Ruang Sidang JSI"

        ));




        return ListJadwal;
    }





    public void buttonBackListMahasiswa(View view) {
        Intent listMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
        startActivity(listMahasiswaIntent);
    }
}