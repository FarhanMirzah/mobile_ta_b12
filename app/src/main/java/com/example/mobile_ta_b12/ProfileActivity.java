package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void editprofile(View view) {
        Intent editprofile = new Intent(ProfileActivity.this, EditProfileActivity.class);
        startActivity(editprofile);
    }

    public void tombolbackprofile(View view) {
        Intent tombolbackprofile = new Intent(ProfileActivity.this, ListMahasiswaActivity.class);
        startActivity(tombolbackprofile);
    }

    public void gantipassword(View view) {
        Intent gantipassword = new Intent(ProfileActivity.this, GantiPasswordActivity.class);
        startActivity(gantipassword);
    }

    public void buttonLogout(View view) {
        Intent logoutIntent = new Intent(this, LoginActivity.class);
        startActivity(logoutIntent);
    }
}