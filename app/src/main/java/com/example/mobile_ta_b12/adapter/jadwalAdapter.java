package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.R;
import com.example.mobile_ta_b12.models.jadwal;

import java.util.ArrayList;

public class jadwalAdapter extends RecyclerView.Adapter<jadwalAdapter.JadwalViewHolder> {

    ArrayList<jadwal> ListJadwal;

    public jadwalAdapter(ArrayList<jadwal> listJadwal) {
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
        jadwal jadwal =ListJadwal.get(position);
        holder.logoJadwal.setImageResource(R.drawable.ic_baseline_date_range_24);
        holder.tipe_jadwal.setText(jadwal.getTipe());
        holder.tanggal.setText(jadwal.getTanggal());
        holder.waktu.setText(jadwal.getWaktu());
        holder.tempat.setText(jadwal.getTempat());
    }

    @Override
    public int getItemCount() {
        return ListJadwal.size();
    }

    public static class JadwalViewHolder extends RecyclerView.ViewHolder {

        public ImageView logoJadwal;
        public TextView tipe_jadwal, tanggal, waktu, tempat;

        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);

            logoJadwal = itemView.findViewById(R.id.logoJadwal);
            tipe_jadwal = itemView.findViewById(R.id.tipe_jadwal);
            tanggal = itemView.findViewById(R.id.tanggal);
            waktu = itemView.findViewById(R.id.waktu);
            tempat = itemView.findViewById(R.id.tempat);
        }
    }
}
