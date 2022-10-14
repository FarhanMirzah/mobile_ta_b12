package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RekomendasiCatatanSeminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_catatan_seminar);
    }

    public void buttonBackListJadwal(View view) {
        Intent ListJadwalIntent = new Intent(this, ListJadwalActivity.class);
        startActivity(ListJadwalIntent);
    }
}