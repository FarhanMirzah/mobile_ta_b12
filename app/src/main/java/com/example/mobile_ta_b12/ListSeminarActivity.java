package com.example.mobile_ta_b12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.adapter.seminarAdapter;
import com.example.mobile_ta_b12.models.seminar;

import java.util.ArrayList;

public class ListSeminarActivity extends AppCompatActivity {

    private RecyclerView rvseminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seminar);
        rvseminar = findViewById(R.id.rv_seminar);

        seminarAdapter Adapter = new seminarAdapter(getSeminar());
        Adapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvseminar.setLayoutManager(layoutManager);
        rvseminar.setAdapter(Adapter);
    }

    public ArrayList<seminar> getSeminar(){
        ArrayList<seminar> ListSeminar = new ArrayList<>();
        ListSeminar.add(new seminar(
                "Seminar",
                "05 Oktober 2022",
                "09.00-11.00",
                "Ruang Sidang JSI"
        ));

        ListSeminar.add(new seminar(
                "Seminar",
                "13 Oktober 2022",
                "10.00-12.00",
                "Ruang Sidang JSI"
        ));

        ListSeminar.add(new seminar(
                "Seminar",
                "25 Oktober 2022",
                "08.00-10.00",
                "Ruang Sidang JSI"
        ));

        return ListSeminar;
    }

    public void buttonBackListJadwal(View view) {
        Intent buttonBackListJadwal = new Intent(this, ListJadwalActivity.class);
        startActivity(buttonBackListJadwal);
    }

}
