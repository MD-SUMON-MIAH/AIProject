package com.example.aiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AudioInputActivity extends AppCompatActivity {

    private ImageView audioImge,muteImage;
    private TextView TopTextView;
    private TextView BottomTextViewBegin,BottomTextViewStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_input);

        audioImge=findViewById(R.id.audio_image);
        muteImage=findViewById(R.id.mute_image);
        BottomTextViewBegin=findViewById(R.id.BeginText);
        BottomTextViewStop=findViewById(R.id.MutText);



        audioImge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioImge.setVisibility(View.GONE);
                muteImage.setVisibility(View.VISIBLE);
                BottomTextViewBegin.setVisibility(View.GONE);
                BottomTextViewStop.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Taking Audio Input",Toast.LENGTH_SHORT).show();
            }
        });
        muteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioImge.setVisibility(View.VISIBLE);
                muteImage.setVisibility(View.GONE);
                BottomTextViewBegin.setVisibility(View.VISIBLE);
                BottomTextViewStop.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Audio is taken",Toast.LENGTH_SHORT).show();
            }
        });






    }
}