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
    private LogbookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logbook);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        Log.d("ListLogbook-Debug", token);

        rvLogbook = findViewById(R.id.rv_logbook);
        rvLogbook.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LogbookAdapter();
        adapter.setListener(this);
        rvLogbook.setAdapter(adapter);

        // Minta data ke server
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

        Call<GetLogbookResponse> call = dosen.getListLogbook("Bearer " + token);
        call.enqueue(new Callback<GetLogbookResponse>() {
            @Override
            public void onResponse(Call<GetLogbookResponse> call, Response<GetLogbookResponse> response) {
                Log.d("ListLogbook-Debug", response.toString());
                GetLogbookResponse getLogbookResponse = response.body();
                if(getLogbookResponse != null){
                    List<LogbooksItem> logbooks = getLogbookResponse.getLogbooks();
                    Log.d("ListLogbook-Debug", String.valueOf(logbooks.size()));
                    adapter.setItemList(logbooks);
                }
            }

            @Override
            public void onFailure(Call<GetLogbookResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemLogbookClick(LogbooksItem logbooks) {
        Intent detailIntent = new Intent(this, DetailLogbookActivity.class);
        detailIntent.putExtra("ID", logbooks.getId());
        detailIntent.putExtra("DATE", logbooks.getDate());
        detailIntent.putExtra("PROGRESS", logbooks.getProgress());
        detailIntent.putExtra("FILE_PROGRESS", logbooks.getFileProgress());
        detailIntent.putExtra("PROBLEM", logbooks.getProblem());
        detailIntent.putExtra("STATUS", logbooks.getStatus());
        startActivity(detailIntent);
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