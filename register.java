package com.example.ca2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class register extends AppCompatActivity {
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
EditText emailR,usernameR, pwdR, confirmpwdR;
Button registerR;
TextView alreadyRegistered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailR = findViewById(R.id.pwdS);
        usernameR = findViewById(R.id.emailS);
        pwdR = findViewById(R.id.confirmpwdR);
        registerR = findViewById(R.id.registerR);
        alreadyRegistered = findViewById(R.id.alreadyRegistered);
        confirmpwdR = findViewById(R.id.confirmpwdR);
        String e, u, p, cp, r, ar;
        e = emailR.getText().toString();
        u = usernameR.getText().toString();
        p = pwdR.getText().toString();
        cp = confirmpwdR.getText().toString();
        r = registerR.getText().toString();
        ar = alreadyRegistered.getText().toString();

        alreadyRegistered.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
        private boolean validateEmail() {
            String emailInput = emailR.getText().toString().trim();
            if (emailInput.isEmpty()) {
                emailR.setError("Field can't be empty");
                return false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                emailR.setError("Please enter a valid email address");
                return false;
            } else {
                emailR.setError(null);
                return true;
            }
        }
    private boolean validateUsername() {
        String usernameInput = usernameR.getText().toString().trim();
        if (usernameInput.isEmpty()) {
            usernameR.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            usernameR.setError("Username too long");
            Toast.makeText(getApplicationContext(),"Username should contain characters less than 15",Toast.LENGTH_LONG).show();
            return false;
        } else {
            usernameR.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = pwdR.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            pwdR.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            pwdR.setError("Password too weak(");
            Toast.makeText(getApplicationContext()," Your password must be greater than equal to 8 characters,also atleast use once [0-9],[A-Z],[a-z],[@#$%^&+=]",Toast.LENGTH_LONG).show();
            return false;
        } else {
            pwdR.setError(null);
            return true;
        }
    }
    private boolean confirmPassword() {
        String passwordInputt = confirmpwdR.getText().toString().trim();
        if (passwordInputt.isEmpty()) {
            confirmpwdR.setError("Field can't be empty");
            return false;
        } else if (!pwdR.getText().toString().equals(passwordInputt)) {
           confirmpwdR.setError("Not matching with password");
            return false;
        } else {
            confirmpwdR.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateUsername() |!confirmPassword() | !validatePassword()) {
            return;
        }
        String input = "Email: " + emailR.getText().toString();
        input += "\n";
        input += "Username: " + usernameR.getText().toString();
        input += "\n";
        input += "Password: " + pwdR.getText().toString();
        input+="\n";
        input+="Confirm Password"+ confirmpwdR.getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        Intent s=new Intent(getApplicationContext(),welcome.class);
        s.putExtra("name",usernameR.getText().toString());
        startActivity(s);

    }




}