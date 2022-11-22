package com.hfad.labnotetoselfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabAdd;
    private Note currentDest = Databse.getNotes().get(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerView);

        System.out.println("Setting up adapter");
        //adapter
        NoteAdapter adapter = new NoteAdapter(getSupportFragmentManager());
        rv.setAdapter(adapter);

        //Manager connects the above two
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);



        fabAdd = findViewById(R.id.fab);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               NewNote dialog = new NewNote(adapter);
               dialog.show(getSupportFragmentManager(), "");
            }
        });

        System.out.println("Before setting up");
    }



}