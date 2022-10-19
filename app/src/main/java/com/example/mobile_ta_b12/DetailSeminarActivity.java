package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSeminarActivity extends AppCompatActivity {

    String hariTanggal, Waktu;
    TextView TextDetailTanggalSeminar, TextDetailWaktuSeminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            hariTanggal = detailIntent.getStringExtra("tanggal");
            Waktu = detailIntent.getStringExtra("waktu");
        }
        TextDetailTanggalSeminar= findViewById(R.id.tanggal_seminar);
        TextDetailWaktuSeminar= findViewById(R.id.jam);
        TextDetailTanggalSeminar.setText(hariTanggal);
        TextDetailWaktuSeminar.setText(Waktu);

    }
    public void buttonAccept(View view) {
        Intent AccIntent = new Intent(this, RekomendasiCatatanSeminarActivity.class);
        startActivity(AccIntent);
    }

    public void buttonRej(View view) {
        Intent RejectIntent = new Intent(this, ListJadwalActivity.class);
        startActivity(RejectIntent);
    }
}