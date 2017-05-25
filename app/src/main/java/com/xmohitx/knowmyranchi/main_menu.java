package com.xmohitx.knowmyranchi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class main_menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Typeface tf2 = Typeface.createFromAsset(getAssets(), "fonts/ubuntu.ttf");
        btn =(Button)findViewById(R.id.button2);
        if (btn != null) {
            btn.setTypeface(tf2);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(main_menu.this,quick_facts.class);
                startActivity(in);
            }
        });
        btn =(Button)findViewById(R.id.button3);
        if (btn != null) {
            btn.setTypeface(tf2);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2= new Intent(main_menu.this,places_to_visit.class);
                startActivity(in2);
            }
        });
        btn =(Button)findViewById(R.id.button4);
        if (btn != null) {
            btn.setTypeface(tf2);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2= new Intent(main_menu.this,find_in_ranchi.class);
                startActivity(in2);
            }
        });
        btn =(Button)findViewById(R.id.button5);
        if (btn != null) {
            btn.setTypeface(tf2);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2= new Intent(main_menu.this,places_to_visit.class);
                startActivity(in2);
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
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
            Intent i= new Intent(main_menu.this,quick_facts.class);
            startActivity(i);
        }
        else if (id == R.id.places_to_visit) {
            // Handle the camera action
            Intent i= new Intent(main_menu.this,places_to_visit.class);
            startActivity(i);
        }
        else if (id == R.id.find_in_ranchi) {
            // Handle the camera action
            Intent i= new Intent(main_menu.this,find_in_ranchi.class);
            startActivity(i);
        }
        else if (id == R.id.about) {
            // Handle the camera action
            Intent i= new Intent(main_menu.this,About.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
