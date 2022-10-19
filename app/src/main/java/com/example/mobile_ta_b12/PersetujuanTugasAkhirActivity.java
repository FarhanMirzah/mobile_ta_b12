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
        Intent butuhPersetujuanIntent = new Intent(this, ListPersetujuanActivity.class);
        startActivity(butuhPersetujuanIntent);
    }
    public void buttonsetuju(View view) {
        Intent buttonsetuju = new Intent(this, ListPersetujuanActivity.class);
        startActivity(buttonsetuju);
    }
    public void buttontolak(View view) {
        Intent buttontolak = new Intent(this, ListPersetujuanActivity.class);
        startActivity(buttontolak);
    }
}