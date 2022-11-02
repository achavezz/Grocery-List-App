package com.example.ktsexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ItemModel> itemModels = new ArrayList<>();
    int[] itemImages = {R.drawable.apple, R.drawable.avocado, R.drawable.banana, R.drawable.chicken, R.drawable.cocacola,
        R.drawable.hotcheetos, R.drawable.icecream, R.drawable.mango, R.drawable.orange, R.drawable.oreocookies,
        R.drawable.papertowels, R.drawable.pepsi, R.drawable.pineapple, R.drawable.strawberries, R.drawable.toilerpaper, R.drawable.waterbottle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpItemModels();

    }

    private void setUpItemModels(){
        String[] itemNames = getResources().getStringArray(R.array.grocery_names_txt);
        int[] itemIDs = getResources().getIntArray(R.array.grocery_id_txt);
        int[] itemCounts = getResources().getIntArray(R.array.grocery_item_count_txt);

        for (int i = 0; i < itemNames.length; i++){
            itemModels.add(new ItemModel(itemNames[i], itemIDs[i], itemCounts[i], itemImages[i]));
        }
    }
}