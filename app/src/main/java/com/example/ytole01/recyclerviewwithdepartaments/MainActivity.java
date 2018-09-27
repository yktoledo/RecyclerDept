package com.example.ytole01.recyclerviewwithdepartaments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new Adapter(this);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);
        rv.setItemAnimator(null);
        populateAdapter();
    }

    private void populateAdapter() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("department1", Item.Type.TITLE, Item.Department.DEP1, true));
        for (int i = 0; i < 10; i++) {
            list.add(new Item("Item "+i, Item.Type.ITEM, Item.Department.DEP1, false));
        }
        list.add(new Item("department2", Item.Type.TITLE, Item.Department.DEP2, true));
        for (int i = 0; i < 10; i++) {
            list.add(new Item("Item "+i, Item.Type.ITEM, Item.Department.DEP2, false));
        }
        list.add(new Item("department3", Item.Type.TITLE, Item.Department.DEP3, true));
        for (int i = 0; i < 10; i++) {
            list.add(new Item("Item "+i, Item.Type.ITEM, Item.Department.DEP3, false));
        }
        list.add(new Item("department4", Item.Type.TITLE, Item.Department.DEP4, true));
        for (int i = 0; i < 10; i++) {
            list.add(new Item("Item "+i, Item.Type.ITEM, Item.Department.DEP4, false));
        }

        adapter.setList(list);
    }
}
