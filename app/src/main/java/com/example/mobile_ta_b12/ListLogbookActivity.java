package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobile_ta_b12.adapter.LogbookAdapter;
import com.example.mobile_ta_b12.models.Logbook;

import java.util.ArrayList;

public class ListLogbookActivity extends AppCompatActivity {

    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        rvLogbook = findViewById(R.id.rv_logbook);

        LogbookAdapter adapter = new LogbookAdapter(getListLogbook());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);
    }

    public void buttonBackDetailTugasAkhir(View view) {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        startActivity(DetailTugasAkhirIntent);
    }

    public ArrayList<Logbook> getListLogbook(){
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
}