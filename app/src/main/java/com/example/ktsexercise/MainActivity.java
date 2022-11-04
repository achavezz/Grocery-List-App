package com.example.ktsexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecylerViewInterface{
    ArrayList<ItemModel> userItemModels = new ArrayList<>();
    ArrayList<ItemModel> itemModels = new ArrayList<>();
    int[] itemImages = {R.drawable.apple, R.drawable.avocado, R.drawable.banana, R.drawable.chicken, R.drawable.cocacola,
        R.drawable.hotcheetos, R.drawable.icecream, R.drawable.mango, R.drawable.orange, R.drawable.oreocookies,
        R.drawable.papertowels, R.drawable.pepsi, R.drawable.pineapple, R.drawable.strawberries, R.drawable.toilerpaper, R.drawable.waterbottle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecylerView);
        setUpItemModels();

        I_RecyclerViewAdapter adapter = new I_RecyclerViewAdapter(this, itemModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button button = findViewById(R.id.mainButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefConfig.writeListPref(getApplicationContext(), userItemModels);

                Intent intent = new Intent(MainActivity.this, UserList.class);
                startActivity(intent);
            }
        });
    }

    private void setUpItemModels(){
        userItemModels = PrefConfig.readListFromPref(this);
        if(userItemModels == null){
            userItemModels = new ArrayList<>();
        }

        String[] itemNames = getResources().getStringArray(R.array.grocery_names_txt);
        int[] itemIDs = getResources().getIntArray(R.array.grocery_id_txt);
        int[] itemCounts = getResources().getIntArray(R.array.grocery_item_count_txt);

        for (int i = 0; i < itemNames.length; i++){
            itemModels.add(new ItemModel(itemNames[i], itemIDs[i], itemCounts[i], itemImages[i]));
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onButtonClick(int position, int tempCount) {
        int itemCount = itemModels.get(position).getItemCount();
        if(tempCount > itemCount){
            Toast.makeText(this, "User input count is larger than listed count", Toast.LENGTH_SHORT).show();
        }
        else
            userItemModels.add(new ItemModel(itemModels.get(position).getItemName(), itemModels.get(position).getItemID(), tempCount, itemModels.get(position).getImage()));
    }
}