package com.example.ca2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText emailS, pwdS;
TextView forgotPwd, registerS;
Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailS=findViewById(R.id.emailS);
        pwdS=findViewById(R.id.pwdS);
        forgotPwd=findViewById(R.id.forgotPwd);
        registerS=findViewById(R.id.registerS);
        signin=findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailS.getText().toString().isEmpty() || pwdS.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please fill the details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String e,p;
                    e=emailS.getText().toString();
                    p=pwdS.getText().toString();
                    if(e.equals(p))
                    {
                        Intent i=new Intent(getApplicationContext(),welcome.class);
                        i.putExtra("name",e);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Wrong Username and  Password",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        registerS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(getApplicationContext(),register.class);
                startActivity(r);
            }
        });
        forgotPwd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent q=new Intent(getApplicationContext(),ForgotPwd.class);
                startActivity(q);
            }
        });

    }
    }