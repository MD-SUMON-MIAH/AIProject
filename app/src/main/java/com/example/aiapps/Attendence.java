package com.example.aiapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Attendence extends AppCompatActivity {

    private ImageView audioImge,muteImage;
    private TextView TopTextView;
    private TextView BottomTextViewBegin,BottomTextViewStop;

    private static int MICROPHONE_PERMISSION=200;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    private ProgressDialog progressBar;
    RecordDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        progressBar=new ProgressDialog(this);
        dbHelper=new RecordDBHelper();

        if(isMicrophonePresent())
            getMicroPhonePermission();

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
                InputVoice();
            }

        });
    }
    public void InputVoice(){
        try{
            mediaRecorder=new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(getRecordingFilePath());
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();
            Toast.makeText(this,"Recording started!", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();

        }

        muteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                audioImge.setVisibility(View.VISIBLE);
                muteImage.setVisibility(View.GONE);
                BottomTextViewBegin.setVisibility(View.VISIBLE);
                BottomTextViewStop.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Audio is taken",Toast.LENGTH_SHORT).show();

                //mediaRecorder.stop();

                mediaRecorder.release();
                mediaRecorder=null;
                upload();
                Toast.makeText(getApplicationContext(),"Sumon",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void btnStopPressed(View view){
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder=null;
        Toast.makeText(this,"Recording stopped!", Toast.LENGTH_LONG).show();
    }

    public void upload() {
//        progressBar.setMessage("uplading..");
//        progressBar.show();

        ///back end implementation...

//        int roll=12;
//        String batch="cse18";
//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd");
//        String strDate = dateFormat.format(date);
//        Record record=new Record(CourseList.course.getCode(),batch,""+strDate,roll);
//        try {
//            dbHelper.add(record).addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void unused) {
//                    progressBar.dismiss();
//                    Toast.makeText(Attendence.this, "Uploaded!", Toast.LENGTH_SHORT).show();
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Log.d("upload", "uploading... ");
    }

    public void btnPlayPressed(View view){

    }
    public  void  play(){
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(getRecordingFilePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(this,"Recording is playing!", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    private boolean isMicrophonePresent(){
        if(this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE))
            return true;
        else
            return false;
    }
    private void getMicroPhonePermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)==
                PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.RECORD_AUDIO},MICROPHONE_PERMISSION);
        }

    }
    private  String getRecordingFilePath(){
        ContextWrapper contextWrapper=new ContextWrapper(getApplicationContext());
        File musicDirectory=contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file= new File(musicDirectory,"testRecordingFile"+".mp3");
        return file.getPath();
    }
}