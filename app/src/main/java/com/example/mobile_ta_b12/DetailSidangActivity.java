package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSidangActivity extends AppCompatActivity {

    String hariTanggal;
    TextView TextDetailTanggalSidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            hariTanggal = detailIntent.getStringExtra("TANGGAL");
        }
        TextDetailTanggalSidang= findViewById(R.id.TextDetailTanggalSidang);
        TextDetailTanggalSidang.setText(hariTanggal);
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

