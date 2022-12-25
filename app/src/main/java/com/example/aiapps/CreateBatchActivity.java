package com.example.aiapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateBatchActivity extends AppCompatActivity {

    Button CreateBatchBtn;
   // Context c;
   // ArrayList<String> Classcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_batch);
        this.setTitle("Creating Batch");

        CreateBatchBtn = findViewById(R.id.batch_create_btn);
        //MyAdapter obj=new MyAdapter(c,Classcode);
      BatchListActivity ob=new BatchListActivity();
        CreateBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="CSE-2021";
                String ss="30";
                ob.ClassCode.add(s);
                 ob.Clik(s,ss);
                Toast.makeText(getApplicationContext(),"Batch Added",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(CreateBatchActivity.this,BatchListActivity.class);
                startActivity(intent);
            }
        });

    }
}