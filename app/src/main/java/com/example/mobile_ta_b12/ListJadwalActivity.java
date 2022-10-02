package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListJadwalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal);
    }

    public void buttonBackListMahasiswa(View view) {
        Intent listMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
        startActivity(listMahasiswaIntent);
    }
}