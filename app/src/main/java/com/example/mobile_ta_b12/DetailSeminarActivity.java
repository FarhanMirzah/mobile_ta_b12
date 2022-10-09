package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSeminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar);
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