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
            status = detailIntent.getIntExtra("STATUS", 0);
        }
        textDetailHariTanggal = findViewById(R.id.textDetailHariTanggal);
        textDetailHariTanggal.setText(hariTanggal);

        textDetailKegiatan = findViewById(R.id.textDetailKegiatan);
        textDetailKegiatan.setText(kegiatan);

        imageStatusLogbook = findViewById(R.id.imageStatusLogbook);
        if(status == 1){
            imageStatusLogbook.setImageResource(R.drawable.ic_check_circle_outline_green);
        }else{
            imageStatusLogbook.setImageResource(R.drawable.ic_access_time_red);
        }
    }

    public void buttonBackListLogbook(View view) {
        Intent ListLogbookIntent = new Intent(this, ListLogbookActivity.class);
        startActivity(ListLogbookIntent);
    }
}