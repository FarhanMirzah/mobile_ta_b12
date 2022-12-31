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
import android.widget.TextView;
import android.widget.Toast;

import id.ac.unand.fti.mobile_ta_b12.models.GetProfileResponse;
import id.ac.unand.fti.mobile_ta_b12.models.UpdateProfileResponse;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditProfileActivity extends AppCompatActivity {

    String email, name, token, gettoken;
    EditText editName, editEmail;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");
        Log.d("UpdateProfile-Debug", token);

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
                Log.d("EditProfile-Debug", response.toString());
                GetProfileResponse getProfileResponse = response.body();
                if(getProfileResponse != null){
                    String email = getProfileResponse.getEmail();
                    String name = getProfileResponse.getName();

                    Log.d("EditProfile-Debug", email + " : " + name);

                    editEmail = (EditText) findViewById(R.id.editEmail);
                    editEmail.setText(email);
                    editName = (EditText) findViewById(R.id.editName);
                    editName.setText(name);
                }
            }

            @Override
            public void onFailure(Call<GetProfileResponse> call, Throwable t) {

            }
        });
    }

    public void updateProfile(View view) {
        editEmail = findViewById(R.id.editEmail);
        editName = findViewById(R.id.editName);
        buttonSave = findViewById(R.id.buttonSave);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
        email = editEmail.getText().toString();
        name = editName.getText().toString();
        Log.d("UpdateProfile-Debug", email + " : " + name);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        gettoken = sharedPref.getString("TOKEN","");
        String token = "Bearer " + gettoken;

        Call<UpdateProfileResponse> call = dosen.updateProfile(token, email, name);
        call.enqueue(new Callback<UpdateProfileResponse>() {
            @Override
            public void onResponse(Call<UpdateProfileResponse> call, Response<UpdateProfileResponse> response) {
                Log.d("UpdateProfile-Debug", response.toString());
                Toast.makeText(EditProfileActivity.this, "Data berhasil di ubah", Toast.LENGTH_SHORT).show();
                Intent profileIntent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profileIntent);
                finish();
            }

            @Override
            public void onFailure(Call<UpdateProfileResponse> call, Throwable t) {
                Log.d("UpdateProfile-Debug", t.toString());
                Toast.makeText(EditProfileActivity.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
            }
        });
    };

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

    @Override
    public void onBackPressed()
    {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        profileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(profileIntent);
        finish();
    }
}