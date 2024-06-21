package com.example.aplikasi_baru;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasi_baru.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    DatabeseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabeseHelper(this);

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etEmail.getText().toString().trim();
                String password = binding.passwordEditText.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Register.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkUserEmail = databaseHelper.checkEmail(email);
                    if (!checkUserEmail) {
                        boolean insert = databaseHelper.insertData(email, password);
                        if (insert) {
                            Toast.makeText(Register.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.passwordEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
