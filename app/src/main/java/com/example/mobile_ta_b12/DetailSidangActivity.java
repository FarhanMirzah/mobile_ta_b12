package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSidangActivity extends AppCompatActivity {

    String hariTanggal, Waktu;
    TextView TextDetailTanggalSidang, TextDetailWaktuSidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            hariTanggal = detailIntent.getStringExtra("TANGGAL");
            Waktu = detailIntent.getStringExtra("WAKTU");
        }
        TextDetailTanggalSidang= findViewById(R.id.TextDetailTanggalSidang);
        TextDetailWaktuSidang= findViewById(R.id.TextDetailWaktuSidang);
        TextDetailTanggalSidang.setText(hariTanggal);
        TextDetailWaktuSidang.setText(Waktu);
    }

    public void buttonAcc(View view) {
        Intent AcceptIntent = new Intent(this, InputNilaiSidangActivity.class);
        startActivity(AcceptIntent);
    }

    public void buttonReject(View view) {
        Intent RejectIntent = new Intent(this, ListJadwalActivity.class);
        startActivity(RejectIntent);
    }



}

