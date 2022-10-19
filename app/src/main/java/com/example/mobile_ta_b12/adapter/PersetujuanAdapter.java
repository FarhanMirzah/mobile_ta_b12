package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.R;
import com.example.mobile_ta_b12.models.Persetujuan;

import java.security.PublicKey;
import java.util.ArrayList;

public class PersetujuanAdapter extends RecyclerView.Adapter<PersetujuanAdapter.PersetujuanViewHolder> {

    ArrayList<Persetujuan> listPersetujuan = new ArrayList<>();
    ItemPersetujuanClickListener listenerpersetujuan;

    public  PersetujuanAdapter(ArrayList<Persetujuan> listPersetujuan){this.listPersetujuan = listPersetujuan;}

    public  PersetujuanAdapter(ArrayList<Persetujuan> listPersetujuan, ItemPersetujuanClickListener listenerpersetujuan){
        this.listPersetujuan = listPersetujuan;
        this.listenerpersetujuan = listenerpersetujuan;
    }

    public void setListPersetujuan(ArrayList<Persetujuan>listPersetujuan) {this.listPersetujuan = listPersetujuan;}
    public void setListenerpersetujuan(ItemPersetujuanClickListener listenerpersetujuan) {this.listenerpersetujuan = listenerpersetujuan;}
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
        holder.imageprofile.setImageResource(R.drawable.default_profile);
        holder.imagedetail.setImageResource(R.drawable.ic_detail_mahasiswa);
        holder.textnama.setText(persetujuan.getNamaMhsP());
        holder.textnim.setText(persetujuan.getNimMhsP());
    }

    @Override
    public int getItemCount(){return listPersetujuan.size();}

    public interface ItemPersetujuanClickListener{
        void onItemPersetujuanClick(Persetujuan persetujuan);
    }
    public  class  PersetujuanViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        public TextView textnim,textnama;
        ImageView imageprofile, imagedetail;

        public PersetujuanViewHolder(@NonNull View itemView){
            super(itemView);
            imageprofile = itemView.findViewById(R.id.imageProfile);
            imagedetail = itemView.findViewById(R.id.imagedetail);
            textnama = itemView.findViewById(R.id.textnama);
            textnim = itemView.findViewById(R.id.textnim);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Persetujuan persetujuan = listPersetujuan.get(getAdapterPosition());
            listenerpersetujuan.onItemPersetujuanClick(persetujuan);
        }
    }
        {

    }
}
