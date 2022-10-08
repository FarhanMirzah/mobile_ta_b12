package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.R;
import com.example.mobile_ta_b12.models.ListJadwal;

import java.util.ArrayList;

public class ListJadwalAdapter extends RecyclerView.Adapter<ListJadwalAdapter.JadwalViewHolder>{

    ArrayList<ListJadwal> ListJadwal = new ArrayList<>();

    public ListJadwalAdapter(ArrayList<com.example.mobile_ta_b12.models.ListJadwal> listJadwal) {
        ListJadwal = listJadwal;
    }

    public void setListJadwal(ArrayList<com.example.mobile_ta_b12.models.ListJadwal> listJadwal) {
        ListJadwal = listJadwal;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jadwal, parent, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        ListJadwal jadwal = ListJadwal.get(position);
        holder.imageJadwal.setImageResource(R.drawable.logo);
       if(jadwal.getTipeJadwal() == 1){
           holder.textJadwalType.setText("Sidang");
       } else {
           holder.textJadwalType.setText("Seminar");
       }
        holder.textTanggal.setText(jadwal.getTanggal());
        holder.textWaktu.setText(jadwal.getWaktu());
        holder.textTempat.setText(jadwal.getTempat());
    }

    @Override
    public int getItemCount() {
        return ListJadwal.size();
    }

    public class JadwalViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageJadwal;
        public TextView textJadwalType, textTanggal, textWaktu, textTempat;


        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageJadwal = itemView.findViewById(R.id.imageJadwal);
            textJadwalType = itemView.findViewById(R.id.textJadwalType);
            textTanggal = itemView.findViewById(R.id.textTanggal);
            textWaktu = itemView.findViewById(R.id.textWaktu);
            textTempat = itemView.findViewById(R.id.textTempat);
        }
    }
}
