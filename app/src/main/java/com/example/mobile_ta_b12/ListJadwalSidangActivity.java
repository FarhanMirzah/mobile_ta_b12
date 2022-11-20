package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.adapter.jadwalAdapter;
import com.example.mobile_ta_b12.models.jadwal;

import java.util.ArrayList;

public class ListJadwalSidangActivity extends AppCompatActivity implements jadwalAdapter.ItemJadwalClickListener {

    private RecyclerView rvjadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_sidang);
        rvjadwal = findViewById(R.id.rvJadwal);

        jadwalAdapter adapter = new jadwalAdapter(getjadwal());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvjadwal.setLayoutManager(layoutManager);
        rvjadwal.setAdapter(adapter);
    }

    public ArrayList<jadwal> getjadwal(){
        ArrayList<jadwal> ListJadwal = new ArrayList<>();
        ListJadwal.add(new jadwal(
                "Sidang",
                "05 Oktober 2022",
                "09.00-11.00",
                "Ruang Sidang JSI"
        ));
        ListJadwal.add(new jadwal(
                "Sidang",
                "13 Oktober 2022",
                "10.00-12.00",
                "Ruang Sidang JSI"
        ));
        ListJadwal.add(new jadwal(
                "Sidang",
                "25 Oktober 2022",
                "08.00-10.00",
                "Ruang Sidang JSI"
        ));

        return ListJadwal;
    }

    public void buttonBackListMahasiswa(View view) {
        onBackPressed();
    }

    public void buttonListJadwalSeminar(View view) {
        Intent buttonListJadwalSeminar = new Intent(this, ListJadwalSeminarActivity.class);
        startActivity(buttonListJadwalSeminar);
    }

    @Override
    public void onItemJadwalClick(com.example.mobile_ta_b12.models.jadwal jadwal) {
        Intent detailIntent = new Intent(this,DetailSidangActivity.class);
        detailIntent.putExtra("TANGGAL",jadwal.getTanggal());
        detailIntent.putExtra("WAKTU",jadwal.getWaktu());
        startActivity(detailIntent);
    }
}