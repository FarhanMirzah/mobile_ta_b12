package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.R;
import com.example.mobile_ta_b12.models.Persetujuan;

import java.util.ArrayList;

public class PersetujuanAdapter extends RecyclerView.Adapter<PersetujuanAdapter.PersetujuanViewHolder> {

    ArrayList<Persetujuan> listPersetujuan = new ArrayList<>();
    ItemPersetujuanClickListener listener;
    public  PersetujuanAdapter(ArrayList<Persetujuan> listPersetujuan){this.listPersetujuan = listPersetujuan;}

    public  PersetujuanAdapter(ArrayList<Persetujuan> listPersetujuan, ItemPersetujuanClickListener listener){
        this.listPersetujuan = listPersetujuan;
        this.listener = listener;
    }

    public void setListPersetujuan(ArrayList<Persetujuan>listPersetujuan) {this.listPersetujuan = listPersetujuan;}

    @NonNull
    @Override

    public PersetujuanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_butuh_persetujuan, parent, false);
        return  new PersetujuanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersetujuanViewHolder holder, int position) {
        Persetujuan persetujuan = this.listPersetujuan.get(position);
        holder.NamaMhsp.setText(persetujuan.getNamaMhsP())
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
