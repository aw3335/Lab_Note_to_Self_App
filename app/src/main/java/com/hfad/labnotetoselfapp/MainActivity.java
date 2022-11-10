package com.hfad.labnotetoselfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Before setting up");
        setUpRecyclerView();
    }

    private void setUpRecyclerView()
    {
        RecyclerView rv = findViewById(R.id.recyclerView);

        System.out.println("Setting up adapter");
        //adapter
        NoteAdapter adapter = new NoteAdapter(getSupportFragmentManager());
        rv.setAdapter(adapter);

        //Manager connects the above two
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);
    }


}