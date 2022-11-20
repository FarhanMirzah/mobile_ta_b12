package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersetujuanTugasAkhirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persetujuan_tugas_akhir);
    }

    public void buttonBackButuhPersetujuan(View view) {
        onBackPressed();
    }
    public void buttonsetuju(View view) {
        onBackPressed();
    }
    public void buttontolak(View view) {
        onBackPressed();
    }
}