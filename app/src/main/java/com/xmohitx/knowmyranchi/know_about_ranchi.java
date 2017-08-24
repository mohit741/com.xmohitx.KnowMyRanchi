package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class know_about_ranchi extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button btn;
    TextView txtv,t;
    ImageView iv,i;
    Typeface tf;

    public static int getR(Integer [] arr)
    {
        int rnd= new Random().nextInt(arr.length);
        return rnd;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_about_ranchi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Integer[] text={R.string.ms,R.string.q4,R.string.q5,R.string.q6,R.string.q8};
        Integer[] imgids={R.drawable.dhoni,R.drawable.ranchi_rino,R.drawable.hec,R.drawable.cip,R.drawable.ssranchi};
        int rand = getR(text);
        TextView txtv=(TextView)findViewById(R.id.textholder);
        txtv.setText(text[rand]);
        ImageView iv=(ImageView)findViewById(R.id.imgholder);
        iv.setImageResource(imgids[rand]);
        tf=Typeface.createFromAsset(getAssets(), "fonts/robotoi.ttf");

        btn =(Button)findViewById(R.id.button1);
        btn.setTypeface(tf);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(know_about_ranchi.this,main_menu.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.moreFacts);
        btn.setTypeface(tf);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(know_about_ranchi.this,quick_facts.class);
                startActivity(in);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.know_about_ranchi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
			finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.quick_facts) {
            // Handle the camera action
            Intent i= new Intent(know_about_ranchi.this,quick_facts.class);
            startActivity(i);
        }
        else if (id == R.id.places_to_visit) {
            // Handle the camera action
            Intent i= new Intent(know_about_ranchi.this,places_to_visit.class);
            startActivity(i);
        }
        else if (id == R.id.find_in_ranchi) {
            // Handle the camera action
            Intent i= new Intent(know_about_ranchi.this,find_in_ranchi.class);
            startActivity(i);
        }
        else if (id == R.id.about) {
            // Handle the camera action
            Intent i= new Intent(know_about_ranchi.this,About.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
