package com.stdio.gridrecyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridLayoutManager gridLayoutManager;
    SimpleAdapter simpleAdapter;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.getItemAnimator().setChangeDuration(700);
        fillList();
        simpleAdapter = new SimpleAdapter(list, this);
        recyclerView.setAdapter(simpleAdapter);
        gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanCount(2);
    }

    private void fillList() {
        for (int i = 0; i < 20; i++) {
            list.add("item " + i);
        }
    }
}