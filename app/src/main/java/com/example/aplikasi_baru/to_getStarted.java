package com.example.aplikasi_baru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class to_getStarted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Set the content view to the layout for this activity
        setContentView(R.layout.activity_to_get_started);

        // Find the button by its ID
        Button button = findViewById(R.id.Create_account);

        // Apply window insets to handle padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set click listener for the button
        button.setOnClickListener(v -> {
            // Start the register activity
            Intent intent = new Intent(to_getStarted.this, Register.class);
            startActivity(intent);
        });
    }

    public void to_login(View view) {
        Intent intent = new Intent(to_getStarted.this, Login.class);
        startActivity(intent);
    }
}
