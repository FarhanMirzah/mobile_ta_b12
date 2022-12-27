package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.unand.fti.mobile_ta_b12.models.GetProfileResponse;
import id.ac.unand.fti.mobile_ta_b12.models.LoginResponse;
import id.ac.unand.fti.mobile_ta_b12.models.LogoutResponse;
import id.ac.unand.fti.mobile_ta_b12.retrofit.APIClient;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    TextView namaUser, nipUser, emailUser;
    String gettoken, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        Log.d("Profile-Debug", token);

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

        Call<GetProfileResponse> login = dosen.getProfile("Bearer " + token);
        login.enqueue(new Callback<GetProfileResponse>() {
            @Override
            public void onResponse(Call<GetProfileResponse> call, Response<GetProfileResponse> response) {
                Log.d("ProfileAct-Debug", response.toString());
                GetProfileResponse getProfileResponse = response.body();
                if(getProfileResponse != null){
                    String nip = getProfileResponse.getUsername();
                    String name = getProfileResponse.getName();
                    String email = getProfileResponse.getEmail();

                    Log.d("ProfileAct-Debug", nip + " : " + name + " : " + email);

                    nipUser = (TextView) findViewById(R.id.nipUser);
                    nipUser.setText(nip);
                    namaUser = (TextView) findViewById(R.id.namaUser);
                    namaUser.setText(name);
                    emailUser = (TextView) findViewById(R.id.emailUser);
                    emailUser.setText(email);
                }
            }

            @Override
            public void onFailure(Call<GetProfileResponse> call, Throwable t) {

            }
        });
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
//        Intent logoutIntent = new Intent(this, LoginActivity.class);
//        logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(logoutIntent);
        InterfaceDosen interfaceDosen = APIClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token","");
        token = "Bearer " + gettoken;
        Toast.makeText(ProfileActivity.this, token, Toast.LENGTH_SHORT).show();

        Call<LogoutResponse> call = InterfaceDosen.logout(token);
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                LogoutResponse logoutResponse = response.body();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                finish();
                Toast.makeText(ProfileActivity.this, logoutResponse.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {

            }
        });


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