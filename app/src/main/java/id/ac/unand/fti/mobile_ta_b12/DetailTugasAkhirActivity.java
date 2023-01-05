package id.ac.unand.fti.mobile_ta_b12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unand.fti.mobile_ta_b12.models.DetailTAMahasiswaResponse;
import id.ac.unand.fti.mobile_ta_b12.models.SupervisorsItem;
import id.ac.unand.fti.mobile_ta_b12.retrofit.APIClient;
import id.ac.unand.fti.mobile_ta_b12.retrofit.InterfaceDosen;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTugasAkhirActivity extends AppCompatActivity {

//        Button inputNilai, batalTA, logBook, seminar, sidang;
//        String gettoken,token;
//        Intent intentExtra;
//        SupervisorsItem pembimbing;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_detail_tugas_akhir);
////        getDetailTA();
////        getDetailTA2();
//
//
//
//            intentExtra = getIntent();
//            if (intentExtra != null) {
//
//                Log.e("ID -", String.valueOf(intentExtra.getIntExtra("id",0)));
//
//                int [] listdosen= {R.id.pembimbing11DetailTA, R.id.pembimbing11DetailTA3};
//                List<String> list = new ArrayList<>();
//
//                InterfaceDosen mainInterface = APIClient.getService();
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY", MODE_PRIVATE);
//                gettoken = sharedPreferences.getString("token", "");
//                token = "Bearer " + gettoken;
////            Toast.makeText(DetailTaMahasiswa.this, token, Toast.LENGTH_SHORT).show();
//                Log.e("Token", token);
//                int idstudent2 = intentExtra.getIntExtra("id", 0);
//                Call<DetailTAMahasiswaResponse> call = mainInterface.detailtaresponse(token,idstudent2);
//                call.enqueue(new Callback<DetailTAMahasiswaResponse>() {
//                    @Override
//                    public void onResponse(Call<DetailTAMahasiswaResponse> call, Response<DetailTAMahasiswaResponse> response) {
//                        Log.e("Suc-", response.toString());
//                        DetailTAMahasiswaResponse detailTAMahasiswaResponse = response.body();
//                        String nama = detailTAMahasiswaResponse.getStudent().getName();
//                        String nim = detailTAMahasiswaResponse.getStudent().getNim();
//                        String judul = detailTAMahasiswaResponse.getTitle();
//                        String ringkasan = detailTAMahasiswaResponse.getJsonMemberAbstract();
//
//
//                        TextView castnama = findViewById(R.id.namaDetailTA);
//                        TextView castnim = findViewById(R.id.nimDetailTA);
//                        TextView castjudul = findViewById(R.id.judul2DetailTA);
//                        TextView castringkasan = findViewById(R.id.ringkasan2DetailTA);
//                        castnama.setText(nama);
//                        castnim.setText(nim);
//                        castjudul.setText(judul);
//                        castringkasan.setText(ringkasan);
//
//                        try {
//                            for (int a = 0 ; a<detailTAMahasiswaResponse.getSupervisors().size() ; a++){
//                                String dospembimbing = detailTAMahasiswaResponse.getSupervisors().get(a).getName();
//                                list.add(dospembimbing);
//                            }
//                            for (int b = 0; b < listdosen.length; b++){
//                                ((TextView)findViewById(listdosen[b])).setText(list.get(b));
//                            }
//
//                        }catch (IndexOutOfBoundsException e){
//
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<DetailTAMahasiswaResponse> call, Throwable t) {
//                        Log.e("fail-", t.getLocalizedMessage());
//                    }
//                });
//                sidang = findViewById(R.id.DetailsidangDetailTAMahasiswa);
//                sidang.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent sidangIn = new Intent(DetailTugasAkhirActivity.this, DetailSidangTugasAkhirActivity.class);
//                        startActivity(sidangIn);
//                    }
//                });
//                seminar = findViewById(R.id.DetailSeminarDetailTAMahasiswa);
//                seminar.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent seminarIn = new Intent(DetailTugasAkhirActivity.this, DetailSeminarTugasAkhirActivity.class);
//                        startActivity(seminarIn);
//                    }
//                });
//                logBook = findViewById(R.id.ListLogbookDetailTAMahasiswa);
//                logBook.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent logBookIn = new Intent(DetailTugasAkhirActivity.this, ListLogbookActivity.class);
//                        startActivity(logBookIn);
//                    }
//                });
//                batalTA = findViewById(R.id.buttonDetailTA5FromBatal);
//                batalTA.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent batalTAIn = new Intent(DetailTugasAkhirActivity.this, PembatalanTugasAkhirActivity.class);
//                        startActivity(batalTAIn);
//                    }
//                });
//                inputNilai = findViewById(R.id.buttonInputDetailTA);
//                inputNilai.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent inputNilaiIn = new Intent(DetailTugasAkhirActivity.this, InputNilaiTugasAkhirActivity.class);
//                        startActivity(inputNilaiIn);
//                    }
//                });
//            }
//
//        }
//    }
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_detail_tugas_akhir);
////    }
////
////    public void buttonBackListMahasiswa(View view) {
////        Intent listMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
////        listMahasiswaIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////        listMahasiswaIntent.putExtra("IS_LOGGED_IN", true);
////        startActivity(listMahasiswaIntent);
////        finish();
////    }
////
////    public void buttonDetailMahasiswa(View view) {
////        Intent DetailMahasiswaIntent = new Intent(this, DetailMahasiswaActivity.class);
////        startActivity(DetailMahasiswaIntent);
////    }
////
////    public void buttonInputNilaiTugasAkhir(View view) {
////        Intent inputNilaiTugasAkhirIntent = new Intent(this, InputNilaiTugasAkhirActivity.class);
////        startActivity(inputNilaiTugasAkhirIntent);
////    }
////
////    public void buttonListLogbook(View view) {
////        Intent listLogbookIntent = new Intent(this, ListLogbookActivity.class);
////        startActivity(listLogbookIntent);
////    }
////
////    public void buttonDetailSeminarTA(View view) {
////        Intent detailSeminarTugasAkhirIntent = new Intent(this, DetailSeminarTugasAkhirActivity.class);
////        startActivity(detailSeminarTugasAkhirIntent);
////    }
////
////    public void buttonDetailSidangTA(View view) {
////        Intent detailSidangTugasAkhirIntent = new Intent(this, DetailSidangTugasAkhirActivity.class);
////        startActivity(detailSidangTugasAkhirIntent);
////    }
////
////    public void buttonBatalTugasAkhir(View view) {
////        Intent batalTugasAkhirIntent = new Intent(this, PembatalanTugasAkhirActivity.class);
////        startActivity(batalTugasAkhirIntent);
////    }
//
//    @Override
//    public void onBackPressed()
//    {
//        Intent listMahasiswaIntent = new Intent(this, ListMahasiswaActivity.class);
//        listMahasiswaIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        listMahasiswaIntent.putExtra("IS_LOGGED_IN", true);
//        startActivity(listMahasiswaIntent);
//        finish();
//    }
//}
}