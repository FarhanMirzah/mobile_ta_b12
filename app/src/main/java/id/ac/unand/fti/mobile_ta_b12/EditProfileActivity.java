package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void buttonBackProfile(View view) {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(profileIntent);
        finish();
    }
    public void buttonCancel(View view) {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(profileIntent);
        finish();
    }
    public void buttonSave(View view) {
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