package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class category extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton imageButton4= (ImageButton) findViewById(R.id.imageButton4);

        imageButton.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openNewActivity( );
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openNewActivity1( );
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openNewActivity2( );
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openNewActivity3( );
            }
        });
    }

    public void openNewActivity () {
        Intent intent = new Intent(this, Dictionary.class);
        startActivity(intent);
    }
    public void openNewActivity1 () {
        Intent intent = new Intent(this, Fictions.class);
        startActivity(intent);
    }
    public void openNewActivity2 () {
        Intent intent = new Intent(this, Educations.class);
        startActivity(intent);
    }
    public void openNewActivity3 () {
        Intent intent = new Intent(this, Novels.class);
        startActivity(intent);
    }


}



