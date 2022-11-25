package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailMahasiswaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);
    }
    public void tombolbackDetailMahasiswa(View view) {
        Intent back = new Intent(this, DetailTugasAkhirActivity.class);
        back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(back);
        finish();
    }
}