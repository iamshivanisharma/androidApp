package com.example.ca2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class welcome extends AppCompatActivity {
ImageView pic;
Button submit;
//TextView person;
    String name;
    Bitmap imageBitmap;
    private static final int REQUEST_IMAGE_CAPTURE =1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent i=getIntent();
        name=i.getStringExtra("name");
        final TextView person=findViewById(R.id.person);
        person.setText(""+name);
        pic=findViewById(R.id.pic);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Bundle b=new Bundle();
                b.putParcelable("Bitmap",imageBitmap);
                b.putString("name",name);
                Intent intent = new Intent(getApplicationContext(),register_status.class);
                intent.putExtras(b);
                Log.e("name ",b.getString("name"));
                startActivity(intent);
            }

        });
    }

    public void google (View v){

        Intent i= new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.com"));
        startActivity(i);


    }

    public void camera(View v){
        Intent s=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(s,1);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            pic.setImageBitmap(imageBitmap);
        }

    }



}
