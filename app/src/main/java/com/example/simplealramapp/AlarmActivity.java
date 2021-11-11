package com.example.simplealramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlarmActivity extends AppCompatActivity {

    Button btnAlarm;
    EditText txtHours, txtMinutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        initControls();

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting alarm value

                int hours = Integer.valueOf(txtHours.getText().toString());
                int minutes = Integer.valueOf(txtMinutes.getText().toString());

                Intent intent = new Intent(AlarmActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putInt("hours", hours);
                bundle.putInt("minutes", minutes);

                intent.putExtra("bundle", bundle);
                startActivity(intent);

            }
        });
    }

    private void initControls(){
        btnAlarm = findViewById(R.id.btnAddAlarm);
        txtHours = findViewById(R.id.txtHours);
        txtMinutes = findViewById(R.id.txtMinutes);


    }

}