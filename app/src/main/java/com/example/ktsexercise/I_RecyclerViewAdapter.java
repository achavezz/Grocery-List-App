package com.example.ktsexercise;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class I_RecyclerViewAdapter extends RecyclerView.Adapter<I_RecyclerViewAdapter.MyViewHolder> {
    private final RecylerViewInterface recylerViewInterface;
    Context context;
    ArrayList<ItemModel> itemModels;


    public I_RecyclerViewAdapter(Context context, ArrayList<ItemModel> itemModels, RecylerViewInterface recylerViewInterface){
        this.context = context;
        this.itemModels = itemModels;
        this.recylerViewInterface = recylerViewInterface;
    }

    @NonNull
    @Override
    public I_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflates the layout and gives the look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyler_view_row, parent, false);
        return new I_RecyclerViewAdapter.MyViewHolder(view, recylerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull I_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigns the values to each of out recycler view row based on our layout file

        holder.tvName.setText(itemModels.get(position).getItemName());
        holder.tvID.setText(itemModels.get(position).getItemID().toString());
        holder.tvCount.setText(itemModels.get(position).getItemCount().toString());
        holder.imageView.setImageResource(itemModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grabs the view from out recycler view row layout file
        ImageView imageView;
        TextView tvName, tvID, tvCount;
        EditText etUser;
        Button button;
        int tempCount = 0;
        public MyViewHolder(@NonNull View itemView, RecylerViewInterface recylerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tvID = itemView.findViewById(R.id.textView2);
            tvCount = itemView.findViewById(R.id.textView3);
            etUser = itemView.findViewById(R.id.editTextNumber2);
            button = itemView.findViewById(R.id.addButton);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String temp = etUser.getText().toString();
                    if(!temp.equals("")){
                        tempCount = Integer.parseInt(temp);
                    }

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
