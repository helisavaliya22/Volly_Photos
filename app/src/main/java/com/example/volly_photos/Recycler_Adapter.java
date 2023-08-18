package com.example.volly_photos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {
    MainActivity mainActivity;
    ArrayList<Model> modellist;
    public Recycler_Adapter(MainActivity mainActivity, ArrayList<Model> modellist) {
        this.mainActivity = mainActivity;
        this.modellist = modellist;
    }

    @NonNull
    @Override
    public Recycler_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.recycler_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter.ViewHolder holder, int position) {
        holder.t1.setText(""+modellist.get(position).getTitle());
        Glide
                .with(mainActivity)
                .load(modellist.get(position).getUrl())
                .placeholder(R.drawable.baseline_refresh_24)
                .centerCrop()
                .into(holder.i1);

        Picasso.get()
                .load(modellist.get(position).getThumbnailUrl())
                .placeholder(R.drawable.rotation)
                .into(holder.i2);
    }

    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1;
        ImageView i1,i2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.title);
            i1 = itemView.findViewById(R.id.url);
            i2 = itemView.findViewById(R.id.thumbnailurl);
        }
    }
}
