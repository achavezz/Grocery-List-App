package com.example.ktsexercise;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class User_RecyclerViewAdapter extends RecyclerView.Adapter<I_RecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<ItemModel> itemModels;

    public User_RecyclerViewAdapter(Context context, ArrayList<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
    }

    @NonNull
    @Override
    public I_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull I_RecyclerViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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


                    if (tempCount > 0){
                        if(recylerViewInterface != null){
                            int pos = getAdapterPosition();

                            if(pos != RecyclerView.NO_POSITION){
                                recylerViewInterface.onButtonClick(pos, tempCount);
                            }
                        }
                    }
                }
            });
        }
    }
}
