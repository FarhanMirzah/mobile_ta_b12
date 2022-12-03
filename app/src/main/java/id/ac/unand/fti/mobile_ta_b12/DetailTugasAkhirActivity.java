package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailTugasAkhirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tugas_akhir);
    }

    public void buttonBackListMahasiswa(View view) {
        Intent listMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
        listMahasiswaIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        listMahasiswaIntent.putExtra("IS_LOGGED_IN", true);
        startActivity(listMahasiswaIntent);
        finish();
    }

    public void buttonDetailMahasiswa(View view) {
        Intent DetailMahasiswaIntent = new Intent(this, DetailMahasiswaActivity.class);
        startActivity(DetailMahasiswaIntent);
    }

    public void buttonInputNilaiTugasAkhir(View view) {
        Intent inputNilaiTugasAkhirIntent = new Intent(this, InputNilaiTugasAkhirActivity.class);
        startActivity(inputNilaiTugasAkhirIntent);
    }

    public void buttonListLogbook(View view) {
        Intent listLogbookIntent = new Intent(this, ListLogbookActivity.class);
        startActivity(listLogbookIntent);
    }

    public void buttonDetailSeminarTA(View view) {
        Intent detailSeminarTugasAkhirIntent = new Intent(this, DetailSeminarTugasAkhirActivity.class);
        startActivity(detailSeminarTugasAkhirIntent);
    }

    public void buttonDetailSidangTA(View view) {
        Intent detailSidangTugasAkhirIntent = new Intent(this, DetailSidangTugasAkhirActivity.class);
        startActivity(detailSidangTugasAkhirIntent);
    }

    public void buttonBatalTugasAkhir(View view) {
        Intent batalTugasAkhirIntent = new Intent(this, PembatalanTugasAkhirActivity.class);
        startActivity(batalTugasAkhirIntent);
    }

    @Override
    public void onBackPressed()
    {
        Intent listMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
        listMahasiswaIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        listMahasiswaIntent.putExtra("IS_LOGGED_IN", true);
        startActivity(listMahasiswaIntent);
        finish();
    }
}