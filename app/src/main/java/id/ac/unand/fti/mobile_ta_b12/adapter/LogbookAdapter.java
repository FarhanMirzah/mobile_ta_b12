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

    ItemLogbookClickListener listener;

    public void setListener(ItemLogbookClickListener listener) {
        this.listener = listener;
    }

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
        holder.id.setText(String.valueOf(logbooks.getId()));
        holder.date.setText(logbooks.getDate());
        holder.progress.setText(logbooks.getProgress());
        holder.file_progress.setText(logbooks.getFileProgress());
        holder.problem.setText(logbooks.getProblem());

        if (logbooks.getStatus() == 0) {
            holder.imageStatus.setImageResource(R.drawable.ic_check_circle_outline_green);
        }else{
            holder.imageStatus.setImageResource(R.drawable.ic_access_time_red);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface ItemLogbookClickListener{
        void onItemLogbookClick(LogbooksItem logbooks);
    }

    public class LogbookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView id, date, progress, file_progress, problem;
        public ImageView imageStatus;

        public LogbookViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            date = itemView.findViewById(R.id.date);
            progress = itemView.findViewById(R.id.progress);
            file_progress = itemView.findViewById(R.id.file_progress);
            problem = itemView.findViewById(R.id.problem);
            imageStatus = itemView.findViewById(R.id.imageStatus);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            LogbooksItem logbooks = itemList.get(getAdapterPosition());
            listener.onItemLogbookClick(logbooks);
        }
    }
}
