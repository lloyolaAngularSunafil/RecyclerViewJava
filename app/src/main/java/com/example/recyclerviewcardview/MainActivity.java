package com.example.recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ListElement> listElementList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        listElementList = new ArrayList<>();
        listElementList.add(new ListElement("#775447","Pedro","México","Activo"));
        listElementList.add(new ListElement("#607d8b","Julio","Tabasco","Activo"));
        listElementList.add(new ListElement("#03a9f4","Alejandra","ChiHuahua","Cancelado"));
        listElementList.add(new ListElement("#f44336","Jessica","Durando","Inactivo"));
        listElementList.add(new ListElement("#009688","Armando","Yucatán","Inactivo"));

        ListAdapter listAdapter = new ListAdapter(listElementList, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }
    public void moveToDescription(ListElement item){
        Intent intent=new Intent(this,DescriptionActivity.class);
        intent.putExtra("ListElement",item);
        startActivity(intent);
    }
}