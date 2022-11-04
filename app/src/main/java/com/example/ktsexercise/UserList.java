package com.example.ktsexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class UserList extends AppCompatActivity implements RecylerViewInterface{

    ArrayList<ItemModel> userList = new ArrayList<>();
    User_RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);

        userList = PrefConfig.readListFromPref(this);

        adapter = new User_RecyclerViewAdapter(this, userList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button button = findViewById(R.id.userButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefConfig.writeListPref(getApplicationContext(), userList);

                Intent intent = new Intent(UserList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onButtonClick(int position, int tempCount) {
        userList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public void onBackPressed() {

    }
}