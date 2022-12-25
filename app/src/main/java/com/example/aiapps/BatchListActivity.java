package com.example.aiapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BatchListActivity extends AppCompatActivity {

    ArrayList<String>Batches;
    Button CreatBatchButtn;
    public List<StoreBatchList> BatchList;
    TextInputLayout BatchText, NoofStndt;
    int i=0;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("BatchList");
    public ArrayList<String> ClassCode=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_list);
        this.setTitle("Batch List");

        Batches =new ArrayList<>();
        ClassCode.add("CSE-2018");
        ClassCode.add("CSE-20177");

        CreatBatchButtn=findViewById(R.id.batch_create_btnEx);
        BatchText=findViewById(R.id.batch_codeEx);
        NoofStndt=findViewById(R.id.NoOfStdntEx);

        CreatBatchButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String batch=BatchText.getEditText().getText().toString();
                String NoOfstd=NoofStndt.getEditText().getText().toString();
                 String key=myRef.push().getKey();
                 StoreBatchList storbtch=new StoreBatchList(batch,NoOfstd);

                myRef.child(key).setValue(storbtch);

                BatchList =new ArrayList<>();
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        BatchList.clear();
                       for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                           //   StoreBatchList Data=dataSnapshot1.getValue(StoreBatchList.class);
                        }

                        Toast.makeText(getApplicationContext(),"Store and retrive",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        AddView();


        ClassCode.add("CSE-2014");
        AddView();
        Clik("ss","ff");

    }

    public void Clik(String ClassCodeText,String NoOfstudent){

        ClassCode.add(ClassCodeText);
        AddView();

    }

    public void AddView() {
        RecyclerView RV=findViewById(R.id.RecycleView);
        RV.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adaptr=new MyAdapter(this,ClassCode);
        RV.setAdapter(adaptr);
        //adaptr.notifyDataSetChanged();
    }
}