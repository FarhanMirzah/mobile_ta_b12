package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
    }

    private void cekLogin() {
            editUsername = findViewById(R.id.editUsername);
            editPassword = findViewById(R.id.editPassword);
            button = findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
                    String username= binding.editUsername.getText().toString();
                    String password = binding.editPassword.getText().toString();
                    Log.d("LoginAct-Debug", username + " : " + password);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(API_BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create() )
                            .client(new OkHttpClient.Builder().build())
                            .build();

                    InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

                    Call<LoginResponse> call = dosen.login(username, password);

                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            LoginResponse loginResponse = response.body();
                            Log.d("LoginAct-Debug", response.toString());
                            if(loginResponse != null && loginResponse.getStatus().equals("success")){
                                Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();

                                String token = loginResponse.getAuthorisation().getToken();
                                String name = loginResponse.getUser().getName();

                                SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("TOKEN", token);
                                editor.apply();

                                Intent mainIntent = new Intent(LoginActivity.this,ListMahasiswaActivity.class);
                                mainIntent.putExtra("NAME", name);
                                mainIntent.putExtra("IS_LOGGED_IN", true);
                                startActivity(mainIntent);
                            }
                            else{
                                Toast.makeText(LoginActivity.this, "Username Atau Password Salah", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.d("LoginAct-Debug", t.toString());
                            Toast.makeText(LoginActivity.this, "Gagal menghubungi server", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });
    }

    @Override
    public void onBackPressed()
    {
        moveTaskToBack(true);
    }
}