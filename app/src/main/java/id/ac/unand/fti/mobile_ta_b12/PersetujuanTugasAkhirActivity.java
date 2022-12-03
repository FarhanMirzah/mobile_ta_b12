package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersetujuanTugasAkhirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persetujuan_tugas_akhir);
    }

    public void buttonBackButuhPersetujuan(View view) {
        Intent butuhPersetujuanIntent = new Intent(this, ListPersetujuanActivity.class);
        butuhPersetujuanIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(butuhPersetujuanIntent);
        finish();
    }
    public void buttonsetuju(View view) {
        Intent buttonsetuju = new Intent(this, ListPersetujuanActivity.class);
        buttonsetuju.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(buttonsetuju);
        finish();
    }
    public void buttontolak(View view) {
        Intent buttontolak = new Intent(this, ListPersetujuanActivity.class);
        buttontolak.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(buttontolak);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent butuhPersetujuanIntent = new Intent(this, ListPersetujuanActivity.class);
        butuhPersetujuanIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(butuhPersetujuanIntent);
        finish();
    }
}