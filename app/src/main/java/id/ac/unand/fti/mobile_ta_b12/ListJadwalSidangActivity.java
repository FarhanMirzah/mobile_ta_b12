package id.ac.unand.fti.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.unand.fti.mobile_ta_b12.adapter.JadwalAdapter;
import id.ac.unand.fti.mobile_ta_b12.models.Jadwal;

import java.util.ArrayList;

public class ListJadwalSidangActivity extends AppCompatActivity implements JadwalAdapter.ItemJadwalClickListener {

    private RecyclerView rvjadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal_sidang);
        rvjadwal = findViewById(R.id.rvJadwal);

        JadwalAdapter adapter = new JadwalAdapter(getjadwal());
        adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvjadwal.setLayoutManager(layoutManager);
        rvjadwal.setAdapter(adapter);
    }

    public ArrayList<Jadwal> getjadwal(){
        ArrayList<Jadwal> listJadwal = new ArrayList<>();
        listJadwal.add(new Jadwal(
                "Sidang",
                "05 Oktober 2022",
                "09.00-11.00",
                "Ruang Sidang JSI"
        ));
        listJadwal.add(new Jadwal(
                "Sidang",
                "13 Oktober 2022",
                "10.00-12.00",
                "Ruang Sidang JSI"
        ));
        listJadwal.add(new Jadwal(
                "Sidang",
                "25 Oktober 2022",
                "08.00-10.00",
                "Ruang Sidang JSI"
        ));

        return listJadwal;
    }

    public void buttonBackListMahasiswa(View view) {
        Intent buttonBackListMahasiswa = new Intent(this, ListMahasiswaActivity.class);
        buttonBackListMahasiswa.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        buttonBackListMahasiswa.putExtra("IS_LOGGED_IN", true);
        startActivity(buttonBackListMahasiswa);
        finish();
    }

    public void buttonListJadwalSeminar(View view) {
        Intent buttonListJadwalSeminar = new Intent(this, ListJadwalSeminarActivity.class);
        startActivity(buttonListJadwalSeminar);
    }

    @Override
    public void onItemJadwalClick(Jadwal jadwal) {
        Intent detailIntent = new Intent(this, DetailSidangJadwalActivity.class);
        detailIntent.putExtra("TANGGAL",jadwal.getTanggal());
        detailIntent.putExtra("WAKTU",jadwal.getWaktu());
        startActivity(detailIntent);
    }

    @Override
    public void onBackPressed()
    {
        Intent buttonBackListMahasiswa = new Intent(this, ListMahasiswaActivity.class);
        buttonBackListMahasiswa.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        buttonBackListMahasiswa.putExtra("IS_LOGGED_IN", true);
        startActivity(buttonBackListMahasiswa);
        finish();
    }
}