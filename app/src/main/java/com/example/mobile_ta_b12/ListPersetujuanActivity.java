package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListPersetujuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persetujuan);
    }
    public void arrowBack(View view) {
        Intent profileIntent = new Intent(this, ListMahasiswaActivity.class);
        startActivity(profileIntent);
    }
}