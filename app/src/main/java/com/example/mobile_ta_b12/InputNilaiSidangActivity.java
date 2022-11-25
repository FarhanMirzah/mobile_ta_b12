package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InputNilaiSidangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai_sidang);
    }

    public void buttonBackListJadwalSidang(View view) {
        Intent ListJadwalSidangIntent = new Intent(this, ListJadwalSidangActivity.class);
        ListJadwalSidangIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ListJadwalSidangIntent);
        finish();
    }
}