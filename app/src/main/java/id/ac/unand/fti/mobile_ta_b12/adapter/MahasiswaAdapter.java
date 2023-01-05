package id.ac.unand.fti.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.unand.fti.mobile_ta_b12.models.Mahasiswa;
import id.ac.unand.fti.mobile_ta_b12.R;
import id.ac.unand.fti.mobile_ta_b12.models.ThesesItem;


import java.util.ArrayList;
import java.util.List;


public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private List<ThesesItem> listMahasiswa = new ArrayList<>();
    ItemMahasiswaClickListener listenerMahasiswa;

    public void setListMahasiswa(List<ThesesItem> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
        notifyDataSetChanged();
    }

    ItemMahasiswaClickListener listener;

    public void setListener(ItemMahasiswaClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        ThesesItem mahasiswa = listMahasiswa.get(position);
        holder.namaMahasiswa.setText(mahasiswa.getStudent().getName());
        holder.nimMahasiswa.setText(mahasiswa.getStudent().getNim());
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public  interface ItemMahasiswaClickListener{
        void onItemMahasiswaClick(ThesesItem mahasiswa);
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView namaMahasiswa, nimMahasiswa;

        public MahasiswaViewHolder(@NonNull View itemView){
            super(itemView);
            namaMahasiswa = itemView.findViewById(R.id.namaMahasiswa);
            nimMahasiswa  = itemView.findViewById(R.id.nimMahasiswa);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick (View view){
            ThesesItem mahasiswa = listMahasiswa.get(getAdapterPosition());
            listener.onItemMahasiswaClick(mahasiswa);
        }
    }
}