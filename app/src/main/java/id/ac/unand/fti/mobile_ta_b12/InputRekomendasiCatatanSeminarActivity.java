package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InputRekomendasiCatatanSeminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_rekomendasi_catatan_seminar);
    }

    public void buttonBackListJadwalSeminar(View view) {
        Intent ListJadwalSeminarIntent = new Intent(this, ListJadwalSeminarActivity.class);
        ListJadwalSeminarIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ListJadwalSeminarIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent ListJadwalSeminarIntent = new Intent(this, ListJadwalSeminarActivity.class);
        ListJadwalSeminarIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ListJadwalSeminarIntent);
        finish();
    }
}