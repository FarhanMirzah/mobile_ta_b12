package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSidangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);
    }
    public void buttonAcc(View view) {
        Intent AcceptIntent = new Intent(this, InputNilaiSidangActivity.class);
        startActivity(AcceptIntent);
    }

    public void buttonReject(View view) {
        Intent RejectIntent = new Intent(this, ListJadwalActivity.class);
        startActivity(RejectIntent);
    }
}

