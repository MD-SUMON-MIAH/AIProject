package com.example.aiapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public static final String TAC=MainActivity.class.getSimpleName();

    private FirebaseAuth mAuth;
    private Toolbar mToolbar;
    private Button TakeAttenceBtn,ViewRecordBtn,GeTVoicSampleBtn,CreatClassBtn,CreateBatchBtn;
    private Button mSearchBtn;
    private ViewPager mViewPager;
   // private SectionPagerAddapter mSectionPagerAddapter;

    private EditText signInEmailText,signInPasswordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();

        TakeAttenceBtn=findViewById(R.id.take_attendance);
        ViewRecordBtn=findViewById(R.id.view_record_btn);
        GeTVoicSampleBtn=findViewById(R.id.get_voice_sample);
        CreatClassBtn=findViewById(R.id.create_class);
        CreateBatchBtn=findViewById(R.id.create_batch);


        CreatClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CreateClassActivity.class);
                startActivity(intent);
            }
        });

        TakeAttenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ClassListActivity.class);
                startActivity(intent);
            }
        });
        CreateBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,BatchListActivity.class);
                startActivity(intent);
            }
        });

        GeTVoicSampleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,BatchListActivity.class);
                startActivity(intent);
            }
        });


    }

/*
    @Override
    public void onStart() {

        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser==null)
        {
            sentToStart();
        }


    }

    private void sentToStart()
    {
        Intent startIntent= new Intent(MainActivity.this,StartActivity2.class);
        startActivity(startIntent);
        finish();
    }

*/

}