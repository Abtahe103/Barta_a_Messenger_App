package com.example.barta_a_messenger_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddContactAdapter {
    private ClickListener clickListener;

    Context context;
    static ArrayList<Contact> list;


    public AddContactAdapter(Context context, ArrayList<Contact> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contactlist,parent,false);
        return new MyViewHolder(v,clickListener);
    }


    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact = list.get(position);
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());

//        ImageView alertImageView = holder.itemView.findViewById(R.id.danger);
//
//        if (record.shouldShowAlert()) {
//            alertImageView.setVisibility(View.VISIBLE);
//        } else {
//            alertImageView.setVisibility(View.INVISIBLE);
//        }
    }

    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name,phone;

        public MyViewHolder(@NonNull View itemView,ClickListener clickListener) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            phone = itemView.findViewById(R.id.textPhone);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
//            clickListener.onItemClick(getAdapterPosition());
        }
    }
    public interface ClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

}