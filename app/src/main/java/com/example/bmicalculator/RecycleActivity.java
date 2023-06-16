package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContact=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView;
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));
        arrContact.add(new ContactModel(R.drawable.profile,"pritam","Developer"));

        RecycleContactAdapter adapter=new RecycleContactAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);

    }
}