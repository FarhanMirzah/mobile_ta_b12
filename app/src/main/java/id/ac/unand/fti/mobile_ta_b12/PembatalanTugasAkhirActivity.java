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

import id.ac.unand.fti.mobile_ta_b12.models.GetProfileResponse;
import id.ac.unand.fti.mobile_ta_b12.models.LoginResponse;
import id.ac.unand.fti.mobile_ta_b12.models.PembatalanTugasAkhirResponse;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PembatalanTugasAkhirActivity extends AppCompatActivity {

    String token, getToken;
    Button buttonBatalTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembatalan_tugas_akhir);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");
        Log.d("PembatalanTA-Debug", token);
    }

    public void batalTA(View view) {
        buttonBatalTA = findViewById(R.id.buttonBatalTA);

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen interfaceDosen = retrofit.create(InterfaceDosen.class);
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        getToken = sharedPref.getString("TOKEN","");
        String token = "Bearer " + getToken;

        Call<PembatalanTugasAkhirResponse> call = interfaceDosen.batalTA(token);
        call.enqueue(new Callback<PembatalanTugasAkhirResponse>() {
            @Override
            public void onResponse(Call<PembatalanTugasAkhirResponse> call, Response<PembatalanTugasAkhirResponse> response) {
                PembatalanTugasAkhirResponse pembatalanTugasAkhirResponse = response.body();
                Log.d("PembatalanTA-Debug", response.toString());
                if(pembatalanTugasAkhirResponse != null && pembatalanTugasAkhirResponse.getStatus().equals("success")) {
                    String message = pembatalanTugasAkhirResponse.getMessage();
                    Toast.makeText(PembatalanTugasAkhirActivity.this, message, Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("TOKEN", token);
                    editor.apply();

                    Intent mainIntent = new Intent(PembatalanTugasAkhirActivity.this,ListMahasiswaActivity.class);
                    mainIntent.putExtra("IS_LOGGED_IN", true);
                    startActivity(mainIntent);
                }
            }

            @Override
            public void onFailure(Call<PembatalanTugasAkhirResponse> call, Throwable t) {

            }
        });
    }

    public void buttonBackDetailTugasAkhir(View view) {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        DetailTugasAkhirIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(DetailTugasAkhirIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        DetailTugasAkhirIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(DetailTugasAkhirIntent);
        finish();
    }
}