package com.example.aiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BatchListActivity extends AppCompatActivity {

    ArrayList<String>Batches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_list);
        this.setTitle("Batch List");

        Batches =new ArrayList<>();
    }
}