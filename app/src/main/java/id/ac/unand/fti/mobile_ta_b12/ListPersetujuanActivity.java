package id.ac.unand.fti.mobile_ta_b12;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.unand.fti.mobile_ta_b12.adapter.PersetujuanAdapter;
import id.ac.unand.fti.mobile_ta_b12.models.ExaminersItem;
import id.ac.unand.fti.mobile_ta_b12.models.ListPermintaanReviewerPersetujuan;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListPersetujuanActivity extends AppCompatActivity implements PersetujuanAdapter.ItemPersetujuanClickListener{

    private RecyclerView rvPersetujuan;
    private PersetujuanAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persetujuan);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        Log.d("ListPersetujuan-Debug", token);

        rvPersetujuan = findViewById(R.id.rv_Persetujuan);
        rvPersetujuan.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PersetujuanAdapter();
        adapter.setListener(this);
        rvPersetujuan.setAdapter(adapter);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(new OkHttpClient.Builder().build())
                .build();

        InterfaceDosen dosen = retrofit.create(InterfaceDosen.class);

        Call<ListPermintaanReviewerPersetujuan> call = dosen.getListPersetujuan("Bearer " + token);
        call.enqueue(new Callback<ListPermintaanReviewerPersetujuan>() {
            @Override
            public void onResponse(Call<ListPermintaanReviewerPersetujuan> call, Response<ListPermintaanReviewerPersetujuan> response) {
                Log.d("ListPersetujuan-Debug", response.toString());
                ListPermintaanReviewerPersetujuan getPersetujuanResponse = response.body();
                if(getPersetujuanResponse != null){
                    List<ExaminersItem> persetujuan = getPersetujuanResponse.getExaminers();
                    Log.d("ListPersetujuan-Debug", String.valueOf(persetujuan.size()));
                    adapter.setItemList(persetujuan);
                }
            }


            public void onFailure(Call<ListPermintaanReviewerPersetujuan> call, Throwable t) {
            }
        });
    }


    public void arrowBackPersetujuan(View view) {
        Intent ListMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
        ListMahasiswaIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ListMahasiswaIntent.putExtra("IS_LOGGED_IN", true);
        startActivity(ListMahasiswaIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent ListMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
        ListMahasiswaIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ListMahasiswaIntent.putExtra("IS_LOGGED_IN", true);
        startActivity(ListMahasiswaIntent);
        finish();
    }


    @Override
    public void onItemPersetujuanClick(ExaminersItem persetujuan) {
        Intent detailIntent = new Intent(this, DetailPersetujuanActivity.class);
        detailIntent.putExtra("id", persetujuan.getId());
        detailIntent.putExtra("nama", persetujuan.getName());
        detailIntent.putExtra("nip", persetujuan.getNip());
        startActivity(detailIntent);


    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}