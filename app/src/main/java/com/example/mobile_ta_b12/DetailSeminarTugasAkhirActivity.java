package com.example.mobile_ta_b12;

import android.content.Intent;
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
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        DetailTugasAkhirIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(DetailTugasAkhirIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        DetailTugasAkhirIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(DetailTugasAkhirIntent);
        finish();
    }
}
