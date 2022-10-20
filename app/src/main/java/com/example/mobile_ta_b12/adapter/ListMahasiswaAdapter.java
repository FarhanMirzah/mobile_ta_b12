package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.models.Mahasiswa;
import com.example.mobile_ta_b12.R;


import java.util.ArrayList;


public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.MahasiswaViewHolder>{
    ArrayList<Mahasiswa>listMahasiswa = new ArrayList<>();
    ItemMahasiswaClickListener listenermahasiswa;

    public ListMahasiswaAdapter(ArrayList<Mahasiswa> listMahasiswa){this.listMahasiswa = listMahasiswa;}

    public ListMahasiswaAdapter(ArrayList<Mahasiswa>listMahasiswa, ItemMahasiswaClickListener listenermahasiswa){
        this.listMahasiswa = listMahasiswa;
        this.listenermahasiswa = listenermahasiswa;
    }

    public void setListMahasiswa(ArrayList<Mahasiswa>listMahasiswa){ this.listMahasiswa = listMahasiswa; }
    public void setListener(ItemMahasiswaClickListener listenermahasiswa){ this.listenermahasiswa = listenermahasiswa; }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa,parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Mahasiswa listpeserta = this.listMahasiswa.get(position);
        holder.nama_mahasiswa.setText(listpeserta.getNama_Mahasiswa());
        holder.nim_mahasiswa.setText(listpeserta.getNim_Mahasiswa());
    }

    @Override
    public int getItemCount() {return listMahasiswa.size();}

    public  interface ItemMahasiswaClickListener{
        void onItemMahasiswaClick(Mahasiswa mahasiswa);
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nama_mahasiswa, nim_mahasiswa;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_mahasiswa = itemView.findViewById(R.id.namaMahasiswa);
            nim_mahasiswa = itemView.findViewById(R.id.nimMahasiswa);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Mahasiswa mahasiswa = listMahasiswa.get(getAdapterPosition());
            listenermahasiswa.onItemMahasiswaClick(mahasiswa);
        }
    }
}