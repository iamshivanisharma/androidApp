package com.example.ca2project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ForgotPwd extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[a-zA-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{8,}" +
                    "$");
    EditText remail,newpwdS, cpwd;
    Button changepwd;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);
        remail= findViewById(R.id.remail);
        newpwdS= findViewById(R.id.newpwdS);
        cpwd=findViewById(R.id.cpwd);
        changepwd=findViewById(R.id.changepwd);
    }


        private boolean validateEmail() {
            String emailInput = remail.getText().toString().trim();
            if (emailInput.isEmpty()) {
                remail.setError("Field can't be empty");
                return false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                remail.setError("Please enter a valid email address");
                return false;
            } else {
                remail.setError(null);
                return true;
            }
        }

        private boolean validatePassword() {
            String passwordInput = newpwdS.getText().toString().trim();
            if (passwordInput.isEmpty()) {
                newpwdS.setError("Field can't be empty");
                return false;
            } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                newpwdS.setError("Password too weak");
                Toast.makeText(getApplicationContext()," Your password must be greater than equal to 8 characters,also atleast use once [0-9],[A-Z],[a-z],[@#$%^&+=]",Toast.LENGTH_LONG).show();
                return false;
            } else {
                newpwdS.setError(null);
                return true;
            }
        }
    private boolean confirmPassword() {
        String passwordInputt = cpwd.getText().toString().trim();
        if (passwordInputt.isEmpty()) {
            cpwd.setError("Field can't be empty");
            return false;
        } else if (!newpwdS.getText().toString().equals(passwordInputt)) {
            newpwdS.setError("Not matching with new password");
            return false;
        } else {
            newpwdS.setError(null);
            return true;
        }
    }

        public void confirmInput(View v) {
            if (!validateEmail() | !confirmPassword() | !validatePassword()) {
                return;
            }
            String input = "Email: " + remail.getText().toString();
            input += "\n";
          input += "New Password: " + newpwdS.getText().toString();
          input+="\n";
             input += "Confirm Password" + cpwd.getText().toString();
             input+="\n";
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

        }




    }
