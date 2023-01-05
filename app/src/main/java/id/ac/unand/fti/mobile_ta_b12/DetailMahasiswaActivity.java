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
    public TextView nama2, nim2, tempatlhr, tanggallhr, nohp;
    Student student;
    ThesesItem thesesItem;
    Intent detailIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        detailIntent = getIntent();
        if (detailIntent != null) {

            namaMahasiswa = detailIntent.getStringExtra("nama");
            nimMahasiswa = detailIntent.getStringExtra("id");
//            tanggallhr = detailIntent.getStringExtra("tanggal lahir");
//            tempatlhr = detailIntent.getStringExtra("tempat lahir");
        }
        nama2 = findViewById(R.id.namaMahasiswa);
        nama2.setText(String.valueOf(namaMahasiswa));

        nim2 = findViewById(R.id.nimMahasiswa);


        InterfaceDosen mainInterface = APIClient.getService();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY", MODE_PRIVATE);
        gettoken = sharedPreferences.getString("token", "");
        token = "Bearer " + gettoken;
        Toast.makeText(DetailMahasiswaActivity.this, token, Toast.LENGTH_SHORT).show();
        Log.e("Token", token);
        int idstudent = detailIntent.getIntExtra("ID", 0);
        Call<DetailMahasiswaResponse> call = mainInterface.detailmahasiswaresponse(token, idstudent);
        call.enqueue(new Callback<DetailMahasiswaResponse>() {
            @Override
            public void onResponse(Call<DetailMahasiswaResponse> call, Response<DetailMahasiswaResponse> response) {
                Log.e("Suc", response.toString());
                DetailMahasiswaResponse detailMahasiswaResponse = response.body();

                TextView castnama = findViewById(R.id.namaDetailMahasiswa);
                TextView castNim = findViewById(R.id.nimDetailMahasiswa);
                TextView casttnggl = findViewById(R.id.email2DetailMahasiswa);
                TextView casttempat = findViewById(R.id.tepattanggallahir2DetailMahasiswa);
                TextView castnohp = findViewById(R.id.noHP2DetailMahasiswa);

                String nama = detailMahasiswaResponse.getStudent().getName();
                String nim = detailMahasiswaResponse.getStudent().getNim();
                String tanggl = detailMahasiswaResponse.getStudent().getBirthday();
                String tempat = detailMahasiswaResponse.getStudent().getBirthplace();
                String nohp = detailMahasiswaResponse.getStudent().getPhone();
                castnama.setText(nama);
                castNim.setText(nim);
                casttnggl.setText(tanggl);
                casttempat.setText(tempat);
                castnohp.setText(nohp);
            }

            @Override
            public void onFailure(Call<DetailMahasiswaResponse> call, Throwable t) {
                Log.e("error", t.getLocalizedMessage());
            }
        });
        button = findViewById(R.id.DetailTADetailMahasiswa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idmahasiswa = idstudent;
                Intent intentExtra = new Intent(DetailMahasiswaActivity.this, DetailTugasAkhirActivity.class);
                intentExtra.putExtra("id", idmahasiswa);
                startActivity(intentExtra);
            }
        });
//
    }

}