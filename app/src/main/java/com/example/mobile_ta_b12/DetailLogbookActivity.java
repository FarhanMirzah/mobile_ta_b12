package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobile_ta_b12.adapter.LogbookAdapter;
import com.example.mobile_ta_b12.models.Logbook;

import java.util.ArrayList;

public class DetailLogbookActivity extends AppCompatActivity {

    private RecyclerView rvLogbook;

    String hariTanggal;
    String kegiatan;
    int status;
    TextView textDetailHariTanggal;
    TextView textDetailKegiatan;
    ImageView imageStatusLogbook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            hariTanggal = detailIntent.getStringExtra("HARI_TANGGAL");
            kegiatan = detailIntent.getStringExtra("KEGIATAN");
//            status = detailIntent.getIntExtra("STATUS", 1);
        }
        textDetailHariTanggal = findViewById(R.id.textDetailHariTanggal);
        textDetailHariTanggal.setText(hariTanggal);

        textDetailKegiatan = findViewById(R.id.textDetailKegiatan);
        textDetailKegiatan.setText(kegiatan);

//        imageStatusLogbook = findViewById(R.id.imageStatusLogbook);
//        imageStatusLogbook.setImageResource(status);
    }

    public void buttonBackListLogbook(View view) {
        Intent ListLogbookIntent = new Intent(this, ListLogbookActivity.class);
        startActivity(ListLogbookIntent);
    }
}