package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class PembatalanTugasAkhirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembatalan_tugas_akhir);
    }

    public void buttonBackDetailTugasAkhir(View view) {
        onBackPressed();
    }
}