package com.example.ca2project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class register_status extends AppCompatActivity {
    TextView name;
    Button back,rud;
    ImageView imageView3;
    ConstraintLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_status);
        name=findViewById(R.id.name);
        back=findViewById(R.id.back);
        rud=findViewById(R.id.ruDone);
        imageView3=findViewById(R.id.imageView3);
        coordinatorLayout=findViewById(R.id.coordinatorLayout);
        Intent intent = getIntent();
        Bundle b=intent.getExtras();
        Bitmap bitmap = (Bitmap) b.getParcelable("Bitmap");
        name.setText(b.getString("name"));
        if(bitmap!=null)
        {
            imageView3.setImageBitmap(bitmap);
        }
//        name.setText(""+intent.getStringExtra("name"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        rud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Registration Done Successfully", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

    }

}