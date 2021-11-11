package com.example.simplealramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Alarm app";
    Button btnSetAlarm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                startActivity(intent);
            }
        });

        // We assume that user has come back from previous activity

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        if(bundle != null){
            int hours = bundle.getInt("hours", -1); 
            int minutes = bundle.getInt("minutes", -1); 
            if(hours != -1){
                if(minutes != -1){
                    Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, hours);
                    alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
                    alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm set from Activity");
                    startActivity(alarmIntent);

                }
            }
        }else{
            Log.d(TAG, "onCreate: Bundle is null");
        }
    }

    private void initControl(){
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
    }
}