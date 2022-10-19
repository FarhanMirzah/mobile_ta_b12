package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.adapter.ListMahasiswaAdapter;
import com.example.mobile_ta_b12.models.Mahasiswa;

import java.util.ArrayList;

public class ListMahasiswaActivity extends AppCompatActivity implements  ListMahasiswaAdapter.ItemMahasiswaClickListener{

    private RecyclerView rvlistmhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        rvlistmhs = findViewById(R.id.rv_listmahasiswa);

        ListMahasiswaAdapter adapter = new ListMahasiswaAdapter(getMahasiswa());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvlistmhs.setLayoutManager(layoutManager);
        rvlistmhs.setAdapter(adapter);

    }


    public ArrayList<Mahasiswa> getMahasiswa() {
        ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
        mahasiswa.add(new Mahasiswa(
                "Thomas Akram",
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
    public void  onItemMahasiswaClick(Mahasiswa mahasiswa){
        Intent iniintentlistmahasiswa = new Intent(this, DetailTugasAkhirActivity.class);
        iniintentlistmahasiswa.putExtra("Nama Mahasiswa", mahasiswa.getNama_Mahasiswa());
        startActivity(iniintentlistmahasiswa);
        }

    public void profile(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, ProfileActivity.class);
        startActivity(intent);


        public void buttonButuhPersetujuan (View view){
            Intent butuhPersetujuanIntent = new Intent(this, ListPersetujuanActivity.class);
            startActivity(butuhPersetujuanIntent);
        }

        public void buttonListJadwal (View view){
            Intent listJadwalIntent = new Intent(this, ListJadwalActivity.class);
            startActivity(listJadwalIntent);
        }
    }
}
