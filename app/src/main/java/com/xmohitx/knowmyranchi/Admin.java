package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin extends AppCompatActivity {

    Button btn;
    TextView t;
    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        btn =(Button)findViewById(R.id.policeButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Admin.this,police.class);
                startActivity(i);
            }
        });
        btn =(Button)findViewById(R.id.highcbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jharkhandhighcourt.nic.in"));
                startActivity(intent);
            }
        });
        btn =(Button)findViewById(R.id.civbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://civilcourtranchi.nic.in"));
                startActivity(intent);
            }
        });
        btn =(Button)findViewById(R.id.dcbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://ranchi.nic.in/ranchi_adm.htm"));
                startActivity(intent);
            }
        });
        btn =(Button)findViewById(R.id.rmcbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://ranchimunicipal.net"));
                startActivity(intent);
            }
        });
        tf=Typeface.createFromAsset(getAssets(),"fonts/robotoi.ttf");
        t=(TextView)findViewById(R.id.hctext);
        t.setTypeface(tf);
        t=(TextView)findViewById(R.id.cctext);
        t.setTypeface(tf);
        t=(TextView)findViewById(R.id.dctext);
        t.setTypeface(tf);
        t=(TextView)findViewById(R.id.rmctext);
        t.setTypeface(tf);

    }
}
