package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mobile_ta_b12.adapter.LogbookAdapter;
import com.example.mobile_ta_b12.models.Logbook;

import java.util.ArrayList;

public class DetailLogbookActivity extends AppCompatActivity {

    private RecyclerView rvLogbook;

    String hariTanggal;
    TextView textDetailHariTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            hariTanggal = detailIntent.getStringExtra("HARI_TANGGAL");
        }
        textDetailHariTanggal = findViewById(R.id.textDetailHariTanggal);
        textDetailHariTanggal.setText(hariTanggal);
    }

    public void buttonBackListLogbook(View view) {
        Intent ListLogbookIntent = new Intent(this, ListLogbookActivity.class);
        startActivity(ListLogbookIntent);
    }
}