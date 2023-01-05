package id.ac.unand.fti.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.unand.fti.mobile_ta_b12.R;
import id.ac.unand.fti.mobile_ta_b12.models.ExaminersItem;

public class PersetujuanAdapter extends RecyclerView.Adapter<PersetujuanAdapter.PersetujuanViewHolder> {

    private List<ExaminersItem> itemList = new ArrayList<>();

    public void setItemList(List<ExaminersItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    ItemPersetujuanClickListener listener;

    public void setListener(ItemPersetujuanClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public PersetujuanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_butuh_persetujuan, parent, false);
        return new PersetujuanViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PersetujuanViewHolder holder, int position) {
        ExaminersItem persetujuan = itemList.get(position);
        holder.id.setText(String.valueOf(persetujuan.getId()));
        holder.nama.setText(persetujuan.getName());
        holder.nip.setText(persetujuan.getNip());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface ItemPersetujuanClickListener {
        void onItemPersetujuanClick(ExaminersItem persetujuan);
    }


        public class PersetujuanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public TextView id, nama, nip;

            public PersetujuanViewHolder(@NonNull View itemView) {
                super(itemView);
                id = itemView.findViewById(R.id.idPersetujuan);
                nama = itemView.findViewById(R.id.namaPersetujuan);
                nip = itemView.findViewById(R.id.nipPersetujuan);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                ExaminersItem persetujuan = itemList.get(getAdapterPosition());
                listener.onItemPersetujuanClick(persetujuan);
            }
        }
}


