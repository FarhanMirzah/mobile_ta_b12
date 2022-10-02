package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ButuhPersetujuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butuh_persetujuan);
    }

    public void buttonBackListMahasiswa(View view) {
        Intent listMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
        startActivity(listMahasiswaIntent);
    }

    public void buttonPersetujuanTA(View view) {
        Intent persetujuanTugasAkhirIntent = new Intent(this, PersetujuanTugasAkhirActivity.class);
        startActivity(persetujuanTugasAkhirIntent);
    }
}