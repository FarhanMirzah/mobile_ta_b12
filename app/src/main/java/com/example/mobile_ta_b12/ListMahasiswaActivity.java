package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListMahasiswaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);
    }

    public void profile(View view) {
        Intent lihatprofile = new Intent(ListMahasiswaActivity.this, ProfileActivity.class);
        startActivity(lihatprofile);
    }
}