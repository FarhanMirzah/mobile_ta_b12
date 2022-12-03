package id.ac.unand.fti.mobile_ta_b12;

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
        tombolbackprofile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        tombolbackprofile.putExtra("IS_LOGGED_IN", true);
        startActivity(tombolbackprofile);
        finish();
    }

    public void gantipassword(View view) {
        Intent gantipassword = new Intent(ProfileActivity.this, GantiPasswordActivity.class);
        startActivity(gantipassword);
    }

    public void buttonLogout(View view) {
        Intent logoutIntent = new Intent(this, LoginActivity.class);
        logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logoutIntent);
    }

    @Override
    public void onBackPressed()
    {
        Intent tombolbackprofile = new Intent(ProfileActivity.this, ListMahasiswaActivity.class);
        tombolbackprofile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        tombolbackprofile.putExtra("IS_LOGGED_IN", true);
        startActivity(tombolbackprofile);
        finish();
    }
}