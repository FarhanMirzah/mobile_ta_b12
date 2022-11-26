package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.R;
import com.example.mobile_ta_b12.models.Seminar;

import java.util.ArrayList;

public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.SeminarViewHolder>{

    ArrayList<Seminar> listSeminar;
    ItemSeminarClickListener listener;

    public SeminarAdapter(ArrayList<Seminar> listSeminar) {
        this.listSeminar = listSeminar;
    }

    public SeminarAdapter() {
    }

    public void setListener(ItemSeminarClickListener listener){
        this.listener = listener;
    }


    @NonNull
    @Override
    public SeminarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_seminar, parent, false);
        return new SeminarAdapter.SeminarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeminarViewHolder holder, int position) {
        Seminar seminar = listSeminar.get(position);
        holder.logoSeminar.setImageResource(R.drawable.ic_baseline_date_range_24);
        holder.TextSeminarType.setText(seminar.getTipe());
        holder.TextTanggalseminar.setText(seminar.getTanggal());
        holder.waktu.setText(seminar.getWaktu());
        holder.tempat.setText(seminar.getTempat());

    }

    @Override
    public int getItemCount() {return listSeminar.size();
    }

    public interface ItemSeminarClickListener{
        void onItemSeminarClick(Seminar seminar);
    }

    public class SeminarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView logoSeminar;
        public TextView TextSeminarType, TextTanggalseminar, waktu, tempat;

        public SeminarViewHolder(@NonNull View itemView) {
            super(itemView);

            logoSeminar = itemView.findViewById(R.id.logoJadwal);
            TextSeminarType = itemView.findViewById(R.id.tipe);
            TextTanggalseminar = itemView.findViewById(R.id.tanggalSeminar);
            waktu = itemView.findViewById(R.id.waktu);
            tempat = itemView.findViewById(R.id.tempat);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Seminar seminar = listSeminar.get(getAdapterPosition());
            listener.onItemSeminarClick(seminar);
        }
    }
}
