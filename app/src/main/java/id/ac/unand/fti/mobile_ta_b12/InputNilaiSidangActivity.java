package id.ac.unand.fti.mobile_ta_b12;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.unand.fti.mobile_ta_b12.models.GetInputNilaiSidangResponse;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InputNilaiSidangActivity extends AppCompatActivity {

    String nilai ,token, gettoken;
    EditText inputNilai;
    Button buttonInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai_sidang);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");
        Log.d("InputNilaiSidang-Debug", token);

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

        Call<GetInputNilaiSidangResponse> login = dosen.InputNilaiSidang("Bearer " + token);
        login.enqueue(new Callback<GetInputNilaiSidangResponse>() {

            @Override
            public void onResponse(Call<GetInputNilaiSidangResponse> call, Response<GetInputNilaiSidangResponse> response) {
                Log.d("InputNilaiSidang-Debug", response.toString());
                GetInputNilaiSidangResponse getInputNilaiSidangResponse = response.body();
                if (getInputNilaiSidangResponse != null) {
                    inputNilai = (EditText) findViewById(R.id.inputNilai);
                    inputNilai.setText(nilai);
                }
            }

            @Override
            public void onFailure(Call<GetInputNilaiSidangResponse> call, Throwable t) {

            }
        });
    }

    public void InputNilaiSidang (View view) {
        {
            inputNilai = findViewById(R.id.inputNilai);
            buttonInput = findViewById(R.id.buttonInput);

            String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
            nilai = inputNilai.getText().toString();
            Log.d("InputNilaiSidang-Debug", " : " + nilai);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create() )
                    .client(new OkHttpClient.Builder().build())
                    .build();

            InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);
            SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
            gettoken = sharedPref.getString("TOKEN","");
            String token = "Bearer " + gettoken;

            Call<GetInputNilaiSidangResponse> call = dosen.InputNilaiSidang(token);
            call.enqueue(new Callback<GetInputNilaiSidangResponse>()
            {
                @Override
                public void onResponse(Call<GetInputNilaiSidangResponse> call, Response<GetInputNilaiSidangResponse> response) {
                    Log.d("InputNilaiSidang-Debug", response.toString());
                    Toast.makeText(InputNilaiSidangActivity.this,"Data berhasil di input", Toast.LENGTH_SHORT).show();
                    Intent InputNilaiSidangIntent = new Intent(InputNilaiSidangActivity.this, ListJadwalSidangActivity.class);
                    InputNilaiSidangIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(InputNilaiSidangIntent);
                    finish();
                }

                @Override
                public void onFailure(Call<GetInputNilaiSidangResponse> call, Throwable t) {
                    Log.d("InputNilaiSidang-Debug", t.toString());
                    Toast.makeText(InputNilaiSidangActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            });
        };
    }

    public void buttonBackListJadwalSidang(View view) {
        Intent ListJadwalSidangIntent = new Intent(this, ListJadwalSidangActivity.class);
        ListJadwalSidangIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ListJadwalSidangIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent ListJadwalSidangIntent = new Intent(this, ListJadwalSidangActivity.class);
        ListJadwalSidangIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ListJadwalSidangIntent);
        finish();
    }
}