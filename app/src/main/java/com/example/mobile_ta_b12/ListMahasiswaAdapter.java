package com.example.mobile_ta_b12;

import android.app.ListActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.ListMahasiswa;

import java.util.ArrayList;

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder>{
    private ArrayList<ListMahasiswa>ListMahasiswa;
    public ListMahasiswaAdapter(ArrayList<ListMahasiswa>list){
        this.ListMahasiswa = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tampilan_list_mahasiswa,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListMahasiswa listpeserta = ListMahasiswa.get(position);
        holder.tvNamaPeserta.setText(listpeserta.getNama_mahasiswa());
        holder.tvNim.setText(listpeserta.getNim_mahasiswa());
    }

    @Override
    public int getItemCount() {
        return ListMahasiswa.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tvNamaPeserta, tvNim;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaPeserta = itemView.findViewById(R.id.namaMahasiswa);
            tvNim = itemView.findViewById(R.id.nimMahasiswa);
        }
    }
}