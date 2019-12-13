package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class KategoriFragment extends Fragment {
    private static final String TAG = "Fragment Kategori";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View rootView = inflater.inflate(R.layout.fargment_kategori, container, false);

        // Find the View that shows the numbers category
        ImageButton mobil = (ImageButton) rootView.findViewById(R.id.mobil);

        // Set a click listener on that View
        mobil.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent mobilIntent = new Intent(getActivity(), MobilActivity.class);

                // Start the new activity
                startActivity(mobilIntent);
            }
        });

        // Find the View that shows the numbers category
        ImageButton motor = (ImageButton) rootView.findViewById(R.id.motor);

        // Set a click listener on that View
        motor.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent motorIntent = new Intent(getActivity(), MotorActivity.class);

                // Start the new activity
                startActivity(motorIntent);
            }
        });
     return rootView;
    }
}