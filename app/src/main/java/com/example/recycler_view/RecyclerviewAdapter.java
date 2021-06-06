package com.example.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.myViewHolder>{
    ArrayList<Model>list;
    Context context;

    public RecyclerviewAdapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_recycler_layout,parent,false);
       return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.username.setText(list.get(position).getUsername());
        holder.password.setText(list.get(position).getPassword());

    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView username,password;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            username=itemView.findViewById(R.id.cs_username);
            password=itemView.findViewById(R.id.cs_password);
        }
    }
}