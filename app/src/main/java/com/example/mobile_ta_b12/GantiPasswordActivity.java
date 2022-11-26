package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GantiPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_password);
    }

    public void buttonBackProfile(View view) {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(profileIntent);
        finish();
    }
    public void ceklis(View view) {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(profileIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(profileIntent);
        finish();
    }
}