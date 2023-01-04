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
    private ArrayList<ThesesItem> listMahasiswa = new ArrayList<>();
    ItemMahasiswaClickListener listenerMahasiswa;

    public void setListMahasiswa(ArrayList<ThesesItem> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
        notifyDataSetChanged();
    }

    public MahasiswaAdapter() {

    }
    //ItemMahasiswaClickListener listenermahasiswa;

    /*public MahasiswaAdapter(ArrayList<Mahasiswa> listMahasiswa){this.listMahasiswa = listMahasiswa;}

    public MahasiswaAdapter(ArrayList<Mahasiswa>listMahasiswa, ItemMahasiswaClickListener listenermahasiswa){
        this.listMahasiswa = listMahasiswa;
        this.listenermahasiswa = listenermahasiswa;
    }

     */

//    public void setListMahasiswa(List<ThesesItem> listMahasiswa){
//        this.listMahasiswa = listMahasiswa;
//        notifyDataSetChanged();
//    }
//    /*public void setListener(ItemMahasiswaClickListener listenermahasiswa){ this.listenermahasiswa = listenermahasiswa; }*/
//
//    public MahasiswaAdapter() {
//
//    }

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

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {


        public TextView namaMahasiswa, nimMahasiswa;

        public MahasiswaViewHolder(@NonNull View itemView){
            super(itemView);
            namaMahasiswa = itemView.findViewById(R.id.namaMahasiswa);
            nimMahasiswa  = itemView.findViewById(R.id.nimMahasiswa);

            itemView.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View view){
                    ThesesItem mahasiswa = listMahasiswa.get((getAdapterPosition()));
                    listenerMahasiswa.onItemMahasiswaClick(mahasiswa);
                }
            });
        }


//        public TextView nama_mahasiswa;
//        public TextView nim_mahasiswa;
//
//
//
//        public MahasiswaViewHolder(View view) {
//            super(view);
//
//            nama_mahasiswa = itemView.findViewById(R.id.namaMahasiswa);
//            nim_mahasiswa = itemView.findViewById(R.id.nimMahasiswa);
//        }

       /* public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_mahasiswa = itemView.findViewById(R.id.namaMahasiswa);
            nim_mahasiswa = itemView.findViewById(R.id.nimMahasiswa);
            */

          /*  itemView.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            ThesesItem listpeserta = listMahasiswa.get(getAdapterPosition());
            listenermahasiswa.onItemMahasiswaClick(listpeserta);
        }

           */
    }
}