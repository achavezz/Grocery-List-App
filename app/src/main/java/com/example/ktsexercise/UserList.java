package com.example.ktsexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class UserList extends AppCompatActivity implements RecylerViewInterface{

    ArrayList<ItemModel> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);

        userList = PrefConfig.readListFromPref(this);

        User_RecyclerViewAdapter adapter = new User_RecyclerViewAdapter(this, userList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onButtonClick(int position, int tempCount) {

    }

    // need to implement removing items from list
}