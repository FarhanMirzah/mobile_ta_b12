package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PembatalanTaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembatalan_ta);
    }

    public void buttonBackDetailTugasAkhir(View view) {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        startActivity(DetailTugasAkhirIntent);
    }
}