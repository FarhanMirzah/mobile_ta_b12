package com.example.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mobile_ta_b12.databinding.ActivityLoginBinding;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    // Kode lama (findViewById)
//    TextInputEditText editUsername, editPassword;

    // Kode baru (View Binding)
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Kode lama (findViewById)
//        setContentView(R.layout.activity_login);

        // Kode baru (View Binding)
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Kode lama (findViewById)
//        editUsername = findViewById(R.id.editUsername);
//        editPassword = findViewById(R.id.editPassword);
    }

    public void onButtonLoginClick(View view) {
        // Kode lama (findViewById)
//        String username = editUsername.getText().toString();
//        String password = editPassword.getText().toString();

        // Kode baru (View Binding)
        String username = binding.editUsername.getText().toString();
        String password = binding.editPassword.getText().toString();

        if(password.equals("123")){
            Intent mainIntent = new Intent(LoginActivity. this,ListMahasiswaActivity.class);
            mainIntent.putExtra("USERNAME", username);
            mainIntent.putExtra("IS_LOGGED_IN", true);
            startActivity(mainIntent);
        }else{
            Toast.makeText(this, "Password salah (username terserah, password = 123", Toast.LENGTH_SHORT).show();
        }
    }
}