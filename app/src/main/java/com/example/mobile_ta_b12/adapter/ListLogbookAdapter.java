package com.example.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_ta_b12.R;
import com.example.mobile_ta_b12.models.ListLogbook;

import java.util.ArrayList;

public class ListLogbookAdapter extends RecyclerView.Adapter<ListLogbookAdapter.ListLogbookViewHolder>{

    ArrayList<ListLogbook> listLogbook = new ArrayList<>();

    public ListLogbookAdapter(ArrayList<ListLogbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    public void setListLogbook(ArrayList<ListLogbook> listLogbook) {
        this.listLogbook = listLogbook;
    }

    @NonNull
    @Override
    public ListLogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_logbook, parent, false);
        return new ListLogbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListLogbookViewHolder holder, int position) {
        ListLogbook logbook = listLogbook.get(position);
        if (logbook.getStatus() == 1) {
            holder.imageStatus.setImageResource(R.drawable.ic_check_circle_outline_green);
        }else{
            holder.imageStatus.setImageResource(R.drawable.ic_access_time_red);
        }
        holder.textHariTanggal.setText(logbook.getHariTanggal());
        holder.textKegiatan.setText(logbook.getKegiatan());
    }

    @Override
    public int getItemCount() {
        return listLogbook.size();
    }

    public class ListLogbookViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageStatus;
        TextView textHariTanggal, textKegiatan;

        public ListLogbookViewHolder(@NonNull View itemView) {
            super(itemView);
            imageStatus = itemView.findViewById(R.id.imageStatus);
            textHariTanggal = itemView.findViewById(R.id.textHariTanggal);
            textKegiatan = itemView.findViewById(R.id.textKegiatan);
        }
    }
}
