package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mobile_ta_b12.adapter.LogbookAdapter;
import com.example.mobile_ta_b12.models.Logbook;

import java.util.ArrayList;

public class ListLogbookActivity extends AppCompatActivity implements LogbookAdapter.ItemLogbookClickListener{

    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        rvLogbook = findViewById(R.id.rv_logbook);

        LogbookAdapter adapter = new LogbookAdapter(getLogbook());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);
    }

    public void buttonBackDetailTugasAkhir(View view) {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        startActivity(DetailTugasAkhirIntent);
    }

    public ArrayList<Logbook> getLogbook(){
        ArrayList<Logbook> logbook = new ArrayList<>();
        logbook.add(new Logbook(
                "Jumat, 6 Mei 2022",
                "Menentukan judul",
                1
        ));
        logbook.add(new Logbook(
                "Sabtu, 7 Mei 2022",
                "Membuat latar belakang",
                0
        ));
        return logbook;
    }

    @Override
    public void onItemLogbookClick(Logbook logbook) {
        Intent detailIntent = new Intent(this, DetailLogbookActivity.class);
        detailIntent.putExtra("HARI_TANGGAL", logbook.getHariTanggal());
        detailIntent.putExtra("KEGIATAN", logbook.getKegiatan());
        detailIntent.putExtra("STATUS", logbook.getStatus());
        startActivity(detailIntent);
    }
}