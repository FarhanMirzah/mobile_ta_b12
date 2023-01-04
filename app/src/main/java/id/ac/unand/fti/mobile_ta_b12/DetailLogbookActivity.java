package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailLogbookActivity extends AppCompatActivity {

    private RecyclerView rvLogbook;

    String date, progress;
    int status;
    TextView dateDetail;
    TextView progressDetail;
    ImageView imageStatusLogbook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            date = detailIntent.getStringExtra("DATE");
            progress = detailIntent.getStringExtra("PROGRESS");
            status = detailIntent.getIntExtra("STATUS", 0);
        }
        dateDetail = findViewById(R.id.dateDetail);
        if(date == null){
            date = "Hari, Tanggal"; //Assign default string
        }
        dateDetail.setText(date);

        progressDetail = findViewById(R.id.progressDetail);
        if(progress == null){
            progress = "Kegiatan"; //Assign default string
        }
        progressDetail.setText(progress);

        imageStatusLogbook = findViewById(R.id.imageStatusLogbook);
        if(status == 1){
            imageStatusLogbook.setImageResource(R.drawable.ic_check_circle_outline_green);
        }else{
            imageStatusLogbook.setImageResource(R.drawable.ic_access_time_red);
        }
    }

    public void buttonBackListLogbook(View view) {
        Intent ListLogbookIntent = new Intent(this, ListLogbookActivity.class);
        ListLogbookIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ListLogbookIntent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent ListLogbookIntent = new Intent(this, ListLogbookActivity.class);
        ListLogbookIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ListLogbookIntent);
        finish();
    }
}