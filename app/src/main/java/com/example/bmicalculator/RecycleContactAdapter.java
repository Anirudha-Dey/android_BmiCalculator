package com.example.bmicalculator;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleContactAdapter extends RecyclerView.Adapter<RecycleContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrCont;
    RecycleContactAdapter(Context context, ArrayList<ContactModel> arrCont){
        this.context=context;
        this.arrCont=arrCont;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.contact_view,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgProfile.setImageResource(arrCont.get(position).img);
        holder.txtName.setText(arrCont.get(position).name);
        holder.txtNumber.setText(arrCont.get(position).number);

    }

    @Override
    public int getItemCount() {
        return arrCont.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber;
        ImageView imgProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtNumber=itemView.findViewById(R.id.txtNumber);
            imgProfile=itemView.findViewById(R.id.imgProfile);
        }
    }
}
