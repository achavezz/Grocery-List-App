package com.example.ktsexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class User_RecyclerViewAdapter extends RecyclerView.Adapter<User_RecyclerViewAdapter.MyViewHolder>{
    private final RecylerViewInterface recylerViewInterface;
    Context context;
    ArrayList<ItemModel> userItemsModels;

    public User_RecyclerViewAdapter(Context context, ArrayList<ItemModel> userItemsModels, RecylerViewInterface recylerViewInterface) {
        this.context = context;
        this.userItemsModels = userItemsModels;
        this.recylerViewInterface = recylerViewInterface;
    }

    @NonNull
    @Override
    public User_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_recyler_view_row, parent, false);
        return new User_RecyclerViewAdapter.MyViewHolder(view, recylerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull User_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(userItemsModels.get(position).getItemName());
        holder.tvID.setText("ID: " + userItemsModels.get(position).getItemID().toString());
        holder.tvCount.setText("Count: " + userItemsModels.get(position).getItemCount().toString());
        holder.imageView.setImageResource(userItemsModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return userItemsModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvName, tvID, tvCount;
        Button button;
        int tempCount = 0;
        public MyViewHolder(@NonNull View itemView, RecylerViewInterface recylerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.userImageView);
            tvName = itemView.findViewById(R.id.userTextView);
            tvID = itemView.findViewById(R.id.userTextView2);
            tvCount = itemView.findViewById(R.id.userTextView3);
            button = itemView.findViewById(R.id.removeButton);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // implement popup to verify user wants to remove item from list
                    if(recylerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recylerViewInterface.onButtonClick(pos, tempCount);
                        }
                    }
                }
            });
        }
    }
}
