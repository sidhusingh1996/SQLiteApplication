package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder>{

    private Context context;
    private ArrayList<Model> modelArrayList;

    // Constructor
    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    // inner ViewHolder class
    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView name, dob, contact;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.data_name);
            dob = itemView.findViewById(R.id.data_dob);
            contact = itemView.findViewById(R.id.data_contact);
        }
    }

    @Override
    public Adapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_card, parent, false);
        return new Adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.Viewholder holder, int position) {
        Model model = modelArrayList.get(position);
        holder.name.setText(model.getName());
        holder.dob.setText(model.getDob());
        holder.contact.setText(model.getContact());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
