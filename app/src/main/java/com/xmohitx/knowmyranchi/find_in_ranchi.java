package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class find_in_ranchi extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_in_ranchi);
        btn =(Button)findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(find_in_ranchi.this,transport.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.button11);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(find_in_ranchi.this,restaurants.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.button7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(find_in_ranchi.this,hospitals.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.button8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(find_in_ranchi.this,education.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.button9);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(find_in_ranchi.this,malls.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(find_in_ranchi.this,theatres.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.button12);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(find_in_ranchi.this,fitness.class);
                startActivity(in);
            }
        });
    }
}
