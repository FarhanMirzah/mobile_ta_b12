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

public class ListJadwalActivity extends AppCompatActivity {

    private RecyclerView rvjadwal;
    private Object jadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal);


        rvjadwal = findViewById(R.id.rvJadwal);

        jadwalAdapter adapter = new jadwalAdapter(getjadwal());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvjadwal.setLayoutManager(layoutManager);
        rvjadwal.setAdapter(adapter);

    }

    public ArrayList<jadwal> getjadwal(){
        ArrayList<jadwal> ListJadwal = new ArrayList<>();
        ListJadwal.add(new jadwal(
                "Sidang",
                "07 Oktober 2022",
                "09.00-11.00",
                "R1.7"
        ));
        return ListJadwal;
    }

    public void buttonBackListMahasiswa(View view) {
        Intent buttonBackListMahasiswa = new Intent(this, ListMahasiswaActivity.class);
        startActivity(buttonBackListMahasiswa);
    }
}