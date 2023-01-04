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

    String date, progress, file_progress, problem;
    int id, status;
    TextView idDetail, dateDetail, progressDetail, file_progressDetail, problemDetail;
    ImageView imageStatusLogbook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            id = detailIntent.getIntExtra("ID", 0);
            date = detailIntent.getStringExtra("DATE");
            progress = detailIntent.getStringExtra("PROGRESS");
            file_progress = detailIntent.getStringExtra("FILE_PROGRESS");
            problem = detailIntent.getStringExtra("PROBLEM");
            status = detailIntent.getIntExtra("STATUS", 0);
        }
        idDetail = findViewById(R.id.idDetail);
        idDetail.setText(String.valueOf(id));

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

        file_progressDetail = findViewById(R.id.file_progressDetail);
        file_progressDetail.setText(file_progress);

        problemDetail = findViewById(R.id.problemDetail);
        problemDetail.setText(problem);

        imageStatusLogbook = findViewById(R.id.imageStatusLogbook);
        if(status == 0){
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