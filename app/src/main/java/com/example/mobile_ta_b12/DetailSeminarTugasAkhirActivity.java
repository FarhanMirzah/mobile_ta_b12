package com.example.mobile_ta_b12;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailSeminarTugasAkhirActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seminar_tugas_akhir);
    }

    public void buttonBackDetailTugasAkhir(View view) {
        onBackPressed();
    }
}
