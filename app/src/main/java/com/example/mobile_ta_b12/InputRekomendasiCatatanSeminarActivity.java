package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class InputRekomendasiCatatanSeminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_rekomendasi_catatan_seminar);
    }

    public void buttonBackListJadwalSeminar(View view) {
        onBackPressed();
        finish();
    }
}