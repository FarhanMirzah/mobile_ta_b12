package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSidangJadwalActivity extends AppCompatActivity {

    String hariTanggal, Waktu;
    TextView TextDetailTanggalSidang, TextDetailWaktuSidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang_jadwal);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            hariTanggal = detailIntent.getStringExtra("TANGGAL");
            Waktu = detailIntent.getStringExtra("WAKTU");
        }
        TextDetailTanggalSidang= findViewById(R.id.TextDetailTanggalSidang);
        TextDetailWaktuSidang= findViewById(R.id.jam);
        TextDetailTanggalSidang.setText(hariTanggal);
        TextDetailWaktuSidang.setText(Waktu);
    }

    public void buttonAcc(View view) {
        Intent AcceptIntent = new Intent(this, InputNilaiSidangActivity.class);
        startActivity(AcceptIntent);
        finish();
    }

    public void buttonReject(View view) {
        onBackPressed();
    }

    public void buttonBackListJadwalSidang(View view) {
        onBackPressed();
    }

}

