package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.unand.fti.mobile_ta_b12.models.DetailMahasiswaResponse;
import id.ac.unand.fti.mobile_ta_b12.models.ListMahasiswaResponse;
import id.ac.unand.fti.mobile_ta_b12.models.Student;
import id.ac.unand.fti.mobile_ta_b12.models.ThesesItem;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import id.ac.unand.fti.mobile_ta_b12.retrofit.APIClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMahasiswaActivity extends AppCompatActivity {
    Button button;
    String namaMahasiswa, nimMahasiswa;
    String gettoken, token;
    public ImageView imageProfil2;
    public TextView namaDetailMahasiswa, nimDetailMahasiswa, tempattaggallahirDetailMahasiswa, tempattanggallahir2DetailMahasiswa, emailDetailMahasiswa;
    Student student;
    ThesesItem thesesItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        Intent detailIntent = getIntent();
        if (detailIntent != null){
//            namaDetailMahasiswa = detailIntent.getStringExtra("namaDetailMahasiswa");
//            nimDetailMahasiswa = detailIntent.getStringExtra("nimDetailMahasiswa");
//            namaDetailMahasiswa = detailIntent.getStringExtra("namaDetailMahasiswa");
//            namaDetailMahasiswa = detailIntent.getStringExtra("namaDetailMahasiswa");


            namaMahasiswa = detailIntent.getStringExtra("namaMahasiswa");
            nimMahasiswa = detailIntent.getStringExtra("nimMahasiswa");

            namaDetailMahasiswa=findViewById(R.id.namaDetailMahasiswa);
            nimDetailMahasiswa=findViewById(R.id.nimDetailMahasiswa);
        }
    }
}



