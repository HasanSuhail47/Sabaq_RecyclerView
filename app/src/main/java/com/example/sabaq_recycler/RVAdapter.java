package com.example.sabaq_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {


    List<Student> studentData;

    public RVAdapter(List<Student> studentData) {
        this.studentData = studentData;
    }
    @NonNull
    @Override

    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        holder.name.setText(studentData.get(position).getName().toString());
        holder.sabaq.setText(studentData.get(position).getSabaq().toString());
        holder.sabqi.setText(studentData.get(position).getSabqi().toString());
        holder.manzil.setText(studentData.get(position).getManzil().toString());

    }

    @Override
    public int getItemCount() {
        return studentData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView sabaq;
        TextView sabqi;
        TextView manzil;

        Student data;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_view);
            sabaq=itemView.findViewById(R.id.sabaq_view);
            sabqi=itemView.findViewById(R.id.sabqi_view);
            manzil=itemView.findViewById(R.id.manzil_view);

        }
    }


    }
