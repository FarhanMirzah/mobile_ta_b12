package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.adapter.PersetujuanAdapter;
import com.example.mobile_ta_b12.models.Persetujuan;

import java.util.ArrayList;

public class ListPersetujuanActivity extends AppCompatActivity {

    private RecyclerView rvPersetujuan;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persetujuan);

        rvPersetujuan = findViewById(R.id.rv_Persetujuan);

        PersetujuanAdapter adapter = new PersetujuanAdapter(getPersetujuan());
        adapter.setListenerpersetujuan(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvPersetujuan.setLayoutManager(layoutManager);
        rvPersetujuan.setAdapter(adapter);
    }




    public ArrayList<Persetujuan> getPersetujuan(){
        ArrayList<Persetujuan> persetujuan = new ArrayList<>();
        persetujuan.add(new Persetujuan(
                "Thomas Akram",
                "2011521014"


        ));
        persetujuan.add(new Persetujuan(
                "M Farhan Ananda",
                "2011522022"

        ));
        return persetujuan;
    }
        @Override
    public  void onItemPersetujuanClickListener(Persetujuan persetujuan){
           Intent detailintentmahasiswa = new Intent(this, DetailTugasAkhirActivity.class);
           detailintentmahasiswa.putExtra("Nama Mahasiswa", persetujuan.getNamaMhsP());
           startActivity(detailintentmahasiswa);
    }


    public void arrowBackPersetujuan(View view) {
        Intent profileIntent = new Intent(this, ListMahasiswaActivity.class);
        startActivity(profileIntent);
    }
}