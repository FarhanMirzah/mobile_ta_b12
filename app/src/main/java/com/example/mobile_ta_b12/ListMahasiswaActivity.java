package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.adapter.MahasiswaAdapter;
import com.example.mobile_ta_b12.databinding.ActivityListMahasiswaBinding;
import com.example.mobile_ta_b12.models.Mahasiswa;

import java.util.ArrayList;

public class ListMahasiswaActivity extends AppCompatActivity implements  MahasiswaAdapter.ItemMahasiswaClickListener{

    private boolean isLoggedIn = false;
    // Kode lama (findViewById)
//    TextView namaUser;

    // Kode baru (View Binding)
    private ActivityListMahasiswaBinding binding;
    private RecyclerView rvlistmhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Kode lama (findViewById)
//        setContentView(R.layout.activity_list_mahasiswa);

        // Kode baru (View Binding)
        binding = ActivityListMahasiswaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("USERNAME");
        isLoggedIn = mainIntent.getBooleanExtra("IS_LOGGED_IN", false);

        if(!isLoggedIn){
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }

        // Kode lama (findViewById)
//        namaUser = (TextView) findViewById(R.id.namaUser);
//        namaUser.setText(username);

        // Kode baru (View Binding)
        binding.namaUser.setText(username);

        rvlistmhs = findViewById(R.id.rv_listmahasiswa);

        MahasiswaAdapter adapter = new MahasiswaAdapter(getMahasiswa());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvlistmhs.setLayoutManager(layoutManager);
        rvlistmhs.setAdapter(adapter);

    }


    public ArrayList<Mahasiswa> getMahasiswa() {
        ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
        mahasiswa.add(new Mahasiswa(
                "Thomas Akram Ferdinan",
                "2011521014"
        ));
        mahasiswa.add(new Mahasiswa(
                "M Farhan Ananda",
                "2011522022"
        ));
        mahasiswa.add(new Mahasiswa(
                "Fathih Alfi",
                "2011523002"

        ));
        mahasiswa.add(new Mahasiswa(
                "Ramadya Arya Pratama",
                "2003040082"
        ));
        return mahasiswa;
    }


    @Override
    public void onItemMahasiswaClick(Mahasiswa mahasiswa){
        Intent iniintentlistmahasiswa = new Intent(this, DetailTugasAkhirActivity.class);
        iniintentlistmahasiswa.putExtra("Nama Mahasiswa", mahasiswa.getNama_Mahasiswa());
        startActivity(iniintentlistmahasiswa);
        }

    public void profile(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void buttonButuhPersetujuan (View view){
        Intent butuhPersetujuanIntent = new Intent(this, ListPersetujuanActivity.class);
        startActivity(butuhPersetujuanIntent);
    }

    public void buttonListJadwal (View view){
        Intent listJadwalIntent = new Intent(this, ListJadwalSidangActivity.class);
        startActivity(listJadwalIntent);
    }
}
