package com.vinappstudio.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

/* recycle view is updated form of list view
 adapter is the middle functionality between recycler view and list view
 MVC is model View Controler  which  means to seprate the one kind of classes ,
 easy to find classes thats why we created new Package
  java - rightclick - package - main  - name it Adapter
  util package may not need now
  but its nice to have these habits */


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_ID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        /*  ListItem item1 = new ListItem("Movie1" , "Its about someone crazy " , "wow...Great");
         ListItem item2 = new ListItem("Movie2" , "Its about someone you " , "wow...");
         hide this for loop if adding items  manually  that's crazy*/
        for (int i = 0; i < 10; i++) {
            ListItem item = new ListItem("name" + (i + 1), "description", "Excellent");
            listItems.add(item);
        }
       /*  listItems.add(item1);
         listItems.add(item2);*/
        adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }
}