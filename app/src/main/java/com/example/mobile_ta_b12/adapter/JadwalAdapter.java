package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.R;
import com.example.mobile_ta_b12.models.Jadwal;

import java.util.ArrayList;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {

    ArrayList<Jadwal> listJadwal;
    ItemJadwalClickListener listener;

    public JadwalAdapter(ArrayList<Jadwal> listJadwal) {
        this.listJadwal = listJadwal;
    }

    public JadwalAdapter() {

    }

    public void setListener(ItemJadwalClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sidang, parent, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        Jadwal jadwal = listJadwal.get(position);
        holder.logoJadwal.setImageResource(R.drawable.ic_baseline_date_range_24);
        holder.tipe_jadwal.setText(jadwal.getTipe());
        holder.tanggal.setText(jadwal.getTanggal());
        holder.waktu.setText(jadwal.getWaktu());
        holder.tempat.setText(jadwal.getTempat());
    }

    @Override
    public int getItemCount() {
        return listJadwal.size();
    }

    public interface ItemJadwalClickListener{
        void onItemJadwalClick(Jadwal jadwal);
    }


    public class JadwalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView logoJadwal;
        public TextView tipe_jadwal, tanggal, waktu, tempat;

        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);

            logoJadwal = itemView.findViewById(R.id.logoJadwal);
            tipe_jadwal = itemView.findViewById(R.id.tipe);
            tanggal = itemView.findViewById(R.id.tanggalSeminar);
            waktu = itemView.findViewById(R.id.waktu);
            tempat = itemView.findViewById(R.id.tempat);

        itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Jadwal jadwal = listJadwal.get(getAdapterPosition());
            listener.onItemJadwalClick(jadwal);
        }
    }
}
