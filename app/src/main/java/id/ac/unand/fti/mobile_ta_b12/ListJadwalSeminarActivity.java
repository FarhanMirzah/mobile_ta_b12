package id.ac.unand.fti.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.unand.fti.mobile_ta_b12.adapter.SeminarAdapter;
import id.ac.unand.fti.mobile_ta_b12.models.Seminar;

import java.util.ArrayList;

public class ListJadwalSeminarActivity extends AppCompatActivity implements SeminarAdapter.ItemSeminarClickListener {

    private RecyclerView rvseminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_seminar);
        rvseminar = findViewById(R.id.rv_seminar);

        SeminarAdapter Adapter = new SeminarAdapter(getSeminar());
        Adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvseminar.setLayoutManager(layoutManager);
        rvseminar.setAdapter(Adapter);
    }

    public ArrayList<Seminar> getSeminar(){
        ArrayList<Seminar> listSeminar = new ArrayList<>();
        listSeminar.add(new Seminar(
                "Seminar",
                "05 Oktober 2022",
                "09.00-11.00",
                "Ruang Sidang JSI"
        ));

        listSeminar.add(new Seminar(
                "Seminar",
                "13 Oktober 2022",
                "10.00-12.00",
                "Ruang Sidang JSI"
        ));

        listSeminar.add(new Seminar(
                "Seminar",
                "25 Oktober 2022",
                "08.00-10.00",
                "Ruang Sidang JSI"
        ));

        listSeminar.add(new Seminar(
                "Seminar",
                "26 Oktober 2022",
                "08.00-10.00",
                "Ruang Sidang JSI"
        ));

        listSeminar.add(new Seminar(
                "Seminar",
                "15 November 2022",
                "07.30-09.30",
                "Ruang Sidang JSI"
        ));

        listSeminar.add(new Seminar(
                "Seminar",
                "3 Desember 2022",
                "13.30-15.30",
                "Ruang Sidang JSI"
        ));

        return listSeminar;
    }

    public void buttonBackListJadwal(View view) {
        Intent buttonBackListJadwalSidang = new Intent(this, ListJadwalSidangActivity.class);
        buttonBackListJadwalSidang.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(buttonBackListJadwalSidang);
        finish();
    }

    @Override
    public void onItemSeminarClick(Seminar seminar) {
        Intent detailIntent = new Intent(this, DetailSeminarJadwalActivity.class);
        detailIntent.putExtra("tanggal",seminar.getTanggal());
        detailIntent.putExtra("waktu",seminar.getWaktu());
        startActivity(detailIntent);
    }

    @Override
    public void onBackPressed()
    {
        Intent buttonBackListJadwalSidang = new Intent(this, ListJadwalSidangActivity.class);
        buttonBackListJadwalSidang.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(buttonBackListJadwalSidang);
        finish();
    }
}

