package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Find the View that shows the activity search
        Button main = (Button) findViewById(R.id.btn_start);

        // Set a click listener on that View
        main.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the activity search is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the activity search
                Intent MainIntent = new Intent(StartActivity.this, MainActivity.class);

                //menampilkan Toast
                Toast.makeText(getApplicationContext(),"Selamat Datang", Toast.LENGTH_SHORT).show();


                // Start the new activity
                startActivity(MainIntent);
                finish();
            }
        });

    }
}