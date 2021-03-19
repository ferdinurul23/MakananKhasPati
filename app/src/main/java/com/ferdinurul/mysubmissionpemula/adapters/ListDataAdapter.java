package com.ferdinurul.mysubmissionpemula.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ferdinurul.mysubmissionpemula.R;
import com.ferdinurul.mysubmissionpemula.models.ModelData;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.viewHolder> {

    private Context context;

    private ArrayList<ModelData> mArrayListData;
    public ListDataAdapter(Context context, ArrayList<ModelData> mArrayList) {
        this.context = context;
        this.mArrayListData = mArrayList;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_adapter_konten, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final viewHolder viewHolder, int i) {
        ModelData modelData = mArrayListData.get(i);
        viewHolder.tv_nama_konten.setText(modelData.getNama_konten());
        viewHolder.tv_kategori.setText(modelData.getKategori());
        viewHolder.tv_rincian.setText(modelData.getDeskripsi());
        Glide.with(viewHolder.itemView.getContext())
                .load(modelData.getKonten())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.iv_konten);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(mArrayListData.get(viewHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayListData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        CircleImageView iv_konten;
        TextView tv_nama_konten, tv_kategori, tv_rincian;

        public viewHolder(View itemView) {
            super(itemView);
            iv_konten = itemView.findViewById(R.id.iv_konten);
            tv_nama_konten = itemView.findViewById(R.id.tv_nama_konten);
            tv_kategori = itemView.findViewById(R.id.tv_kategori);
            tv_rincian = itemView.findViewById(R.id.tv_rincian);
        }

    }

    public interface OnItemClickCallback {
        void onItemClicked(ModelData data);
    }

}
