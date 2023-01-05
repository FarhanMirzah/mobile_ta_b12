package id.ac.unand.fti.mobile_ta_b12;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.unand.fti.mobile_ta_b12.adapter.MahasiswaAdapter;
import id.ac.unand.fti.mobile_ta_b12.databinding.ActivityListMahasiswaBinding;
import id.ac.unand.fti.mobile_ta_b12.models.GetProfileResponse;
import id.ac.unand.fti.mobile_ta_b12.models.ListMahasiswaResponse;
import id.ac.unand.fti.mobile_ta_b12.models.Mahasiswa;
import id.ac.unand.fti.mobile_ta_b12.models.ThesesItem;
import id.ac.unand.fti.mobile_ta_b12.retrofit.APIClient;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class ListMahasiswaActivity extends AppCompatActivity implements MahasiswaAdapter.ItemMahasiswaClickListener {

    private boolean isLoggedIn = false;
    // Kode lama (findViewById)
    TextView namaUser;
    // Kode baru (View Binding)
    private ActivityListMahasiswaBinding binding;
    private RecyclerView rvlistmhs;
    private  MahasiswaAdapter adapter;
    String gettoken, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Kode lama (findViewById)
//        setContentView(R.layout.activity_list_mahasiswa);

        // Kode baru (View Binding)
        binding = ActivityListMahasiswaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        Log.d("ListMahasiswa-Debug", token);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("TOKEN", token);
        editor.apply();

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

                    namaUser = (TextView) findViewById(R.id.namaUser);
                    namaUser.setText(name);
                }
            }

            @Override
            public void onFailure(Call<GetProfileResponse> call, Throwable t) {

            }
        });

        Intent mainIntent = getIntent();

        // Tidak dipakai lagi
//        String name = mainIntent.getStringExtra("NAME");
//        if(name == null){
//            name = "Name"; //Assign default string
//        }

        // Ganti defaultValue ke true jika ingin langsung ke List Mahasiswa tanpa Login
        isLoggedIn = mainIntent.getBooleanExtra("IS_LOGGED_IN", false);

        if(!isLoggedIn){
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }


        // Kode lama (findViewById)
//        namaUser = (TextView) findViewById(R.id.namaUser);
//        namaUser.setText(name);

        // Kode baru (View Binding) - Tidak dipakai lagi
//        binding.namaUser.setText(name);

        rvlistmhs = findViewById(R.id.rv_listmahasiswa);

//        MahasiswaAdapter adapter = new MahasiswaAdapter(getMahasiswa());
//        adapter.setListener(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvlistmhs.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MahasiswaAdapter();
        rvlistmhs.setAdapter(adapter);

        InterfaceDosen interfaceDosen = APIClient.getService();
        SharedPreferences sharedPreferences = getSharedPreferences("com.kelompok12.SHARED_KEY",MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token","");

        Call<ListMahasiswaResponse>call = interfaceDosen.listmahasiswaresponse("Bearer " + token);
        call.enqueue(new Callback<ListMahasiswaResponse>() {
            @Override
            public void onResponse(Call<ListMahasiswaResponse> call, Response<ListMahasiswaResponse> response) {
                Log.d("ListMahasiswa-Debug", response.toString());
                ListMahasiswaResponse listMahasiswaResponse1=response.body();
                if(listMahasiswaResponse1 != null){
                    List<ThesesItem>theses =listMahasiswaResponse1.getTheses();
                    adapter.setListMahasiswa((ArrayList<ThesesItem>)theses);
                }

            }

            @Override
            public void onFailure(Call<ListMahasiswaResponse> call, Throwable t) {

            }
        });

    }
    @Override
    public void onItemMahasiswaClick(ThesesItem thesesItem){
        Intent listmahasiswa = new Intent(this, DetailMahasiswaActivity.class);
        listmahasiswa.putExtra("nama", thesesItem.getStudent().getName());
        listmahasiswa.putExtra("Id", thesesItem.getId());
        startActivity(listmahasiswa);
}

//
//    public ArrayList<Mahasiswa> getMahasiswa() {
//        ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
//        mahasiswa.add(new Mahasiswa(
//                "Thomas Akram Ferdinan",
//                "2011521014"
//        ));
//        mahasiswa.add(new Mahasiswa(
//                "M Farhan Ananda",
//                "2011522022"
//        ));
//        mahasiswa.add(new Mahasiswa(
//                "Fathih Alfi",
//                "2011523002"
//
//        ));
//        mahasiswa.add(new Mahasiswa(
//                "Ramadya Arya Pratama",
//                "2003040082"
//        ));
//        return mahasiswa;
//    }


//    @Override
//    public void onItemMahasiswaClick(Mahasiswa mahasiswa){
//        Intent iniintentlistmahasiswa = new Intent(this, DetailTugasAkhirActivity.class);
//        iniintentlistmahasiswa.putExtra("Nama Mahasiswa", mahasiswa.getNama_Mahasiswa());
//        startActivity(iniintentlistmahasiswa);
//        }



    public void profile(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
//
    public void buttonButuhPersetujuan (View view){
        Intent butuhPersetujuanIntent = new Intent(this, ListPersetujuanActivity.class);
        startActivity(butuhPersetujuanIntent);
    }

    public void buttonListJadwal (View view){
        Intent listJadwalIntent = new Intent(this, ListJadwalSidangActivity.class);
        startActivity(listJadwalIntent);
    }

    @Override
    public void onBackPressed()
    {
        moveTaskToBack(true);
    }
}
