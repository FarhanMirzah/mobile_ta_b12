package id.ac.unand.fti.mobile_ta_b12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.unand.fti.mobile_ta_b12.R;
import id.ac.unand.fti.mobile_ta_b12.models.Logbook;
import id.ac.unand.fti.mobile_ta_b12.models.LogbooksItem;

import java.util.ArrayList;
import java.util.List;

public class LogbookAdapter extends RecyclerView.Adapter<LogbookAdapter.LogbookViewHolder>{
    private List<LogbooksItem> itemList = new ArrayList<>();

    public void setItemList(List<LogbooksItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }
    // Komentar = kode lama
//    ArrayList<Logbook> listLogbook = new ArrayList<>();
//    ItemLogbookClickListener listener;
//
//    public LogbookAdapter(ArrayList<Logbook> listLogbook) {
//        this.listLogbook = listLogbook;
//    }
//
//    public LogbookAdapter(ArrayList<Logbook> listLogbook, ItemLogbookClickListener listener) {
//        this.listLogbook = listLogbook;
//        this.listener = listener;
//    }
//
//    public void setListLogbook(ArrayList<Logbook> listLogbook) {
//        this.listLogbook = listLogbook;
//    }
//
//    public void setListener(ItemLogbookClickListener listener) {
//        this.listener = listener;
//    }

    @NonNull
    @Override
    public LogbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_logbook, parent, false);
        return new LogbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookViewHolder holder, int position) {
        LogbooksItem logbooks = itemList.get(position);
        holder.progress.setText(logbooks.getProgress());

        // Komentar = kode lama
//        Logbook logbook = this.listLogbook.get(position);
//        if (logbook.getStatus() == 1) {
//            holder.imageStatus.setImageResource(R.drawable.ic_check_circle_outline_green);
//        }else{
//            holder.imageStatus.setImageResource(R.drawable.ic_access_time_red);
//        }
//        holder.textHariTanggal.setText(logbook.getHariTanggal());
//        holder.textKegiatan.setText(logbook.getKegiatan());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Komentar = kode lama
//    public interface ItemLogbookClickListener{
//        void onItemLogbookClick(Logbook logbook);
//    }

    // Komentar = kode lama
//    public class LogbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public class LogbookViewHolder extends RecyclerView.ViewHolder{
        public TextView progress;
        public ImageView imageStatus;

        public LogbookViewHolder(@NonNull View itemView) {
            super(itemView);
            progress = itemView.findViewById(R.id.progress);
            imageStatus = itemView.findViewById(R.id.imageStatus);
//            itemView.setOnClickListener(this);
        }

        // Komentar = kode lama
//        @Override
//        public void onClick(View view) {
//            Logbook logbook = listLogbook.get(getAdapterPosition());
//            listener.onItemLogbookClick(logbook);
//        }
    }
}
