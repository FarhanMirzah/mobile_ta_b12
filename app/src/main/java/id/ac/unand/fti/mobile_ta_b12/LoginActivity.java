package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.unand.fti.mobile_ta_b12.databinding.ActivityLoginBinding;
import id.ac.unand.fti.mobile_ta_b12.models.LoginResponse;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    // Kode lama (findViewById)
//    TextInputEditText editUsername, editPassword;

    // Kode baru (View Binding)
    private ActivityLoginBinding binding;

    EditText editUsername, editPassword;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Kode lama (findViewById)
//        setContentView(R.layout.activity_login);

        // Kode baru (View Binding)
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        cekLogin();



        // Kode lama (findViewById)
//        editUsername = findViewById(R.id.editUsername);
//        editPassword = findViewById(R.id.editPassword);
    }

    private void cekLogin() {
            editUsername = findViewById(R.id.editUsername);
            editPassword = findViewById(R.id.editPassword);
            button = findViewById(R.id.button);

            String username= binding.editUsername.getText().toString();
            String password = binding.editPassword.getText().toString();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(API_BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create() )
                            .client(new OkHttpClient.Builder().build())
                            .build();

                    InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

                    Call<LoginResponse> login = dosen.login(username, password);

                    login.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            LoginResponse loginResponse = response.body();
                            if(loginResponse != null){
                                Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                                Intent homeIntent = new Intent(LoginActivity.this,ListMahasiswaActivity.class);
                                startActivity(homeIntent);
                            }
                            else{
                                Toast.makeText(LoginActivity.this, "Username Atau Pasword Salah", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Gagal menghubungi server", Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            });
    }




//    public void onButtonLoginClick(View view) {
//        // Kode lama (findViewById)
////        String username = editUsername.getText().toString();
////        String password = editPassword.getText().toString();
//
//        // Kode baru (View Binding)
//        String username = binding.editUsername.getText().toString();
//        String password = binding.editPassword.getText().toString();
//
//        if(username.equals("Husnil Kamil") && password.equals("123")){
//            Intent mainIntent = new Intent(LoginActivity. this,ListMahasiswaActivity.class);
//            mainIntent.putExtra("USERNAME", username);
//            mainIntent.putExtra("IS_LOGGED_IN", true);
//            startActivity(mainIntent);
//            finish();
//        }else{
//            Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onBackPressed()
//    {
//        moveTaskToBack(true);
//    }
}