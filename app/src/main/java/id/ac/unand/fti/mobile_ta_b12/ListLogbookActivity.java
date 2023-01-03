package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import id.ac.unand.fti.mobile_ta_b12.adapter.LogbookAdapter;
import id.ac.unand.fti.mobile_ta_b12.models.GetLogbookResponse;
import id.ac.unand.fti.mobile_ta_b12.models.Logbook;
import id.ac.unand.fti.mobile_ta_b12.models.LogbooksItem;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class ListLogbookActivity extends AppCompatActivity implements LogbookAdapter.ItemLogbookClickListener{

    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        Log.d("ListLogbook-Debug", token);

        rvLogbook = findViewById(R.id.rv_logbook);

        LogbookAdapter adapter = new LogbookAdapter(getLogbook());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

        Call<GetLogbookResponse> call = dosen.getListLogbook();
        call.enqueue(new Callback<GetLogbookResponse>() {
            @Override
            public void onResponse(Call<GetLogbookResponse> call, Response<GetLogbookResponse> response) {
                Log.d("ListLogbook-Debug", response.toString());
                GetLogbookResponse getLogbookResponse = response.body();
                if(getLogbookResponse != null){
                    List<LogbooksItem> logbooks = getLogbookResponse.getLogbooks();
                    adapter.setItemList(logbooks);
                }
            }

            @Override
            public void onFailure(Call<GetLogbookResponse> call, Throwable t) {

            }
        });
    }

    public void buttonBackDetailTugasAkhir(View view) {
        Intent DetailTugasAkhirIntent = new Intent(this, DetailTugasAkhirActivity.class);
        DetailTugasAkhirIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(DetailTugasAkhirIntent);
        finish();
    }

    public ArrayList<Logbook> getLogbook(){
        ArrayList<Logbook> logbook = new ArrayList<>();
        logbook.add(new Logbook(
                "Jumat, 6 Mei 2022",
                "Menentukan judul",
                1
        ));
        logbook.add(new Logbook(
                "Sabtu, 7 Mei 2022",
                "Membuat latar belakang",
                0
        ));
        return logbook;
    }

    @Override
    public void onItemLogbookClick(Logbook logbook) {
        Intent detailIntent = new Intent(this, DetailLogbookActivity.class);
        detailIntent.putExtra("HARI_TANGGAL", logbook.getHariTanggal());
        detailIntent.putExtra("KEGIATAN", logbook.getKegiatan());
        detailIntent.putExtra("STATUS", logbook.getStatus());
        startActivity(detailIntent);
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