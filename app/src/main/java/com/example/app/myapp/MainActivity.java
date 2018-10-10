package com.example.app.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ImageView mImageButton;
    private LinearLayout complainBtn,informationButton,mapButton,helpButton;
    private ConstraintLayout helpButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        complainBtn = findViewById(R.id.complainBtn);
        informationButton = findViewById(R.id.informationButton);
        mapButton = findViewById(R.id.mapButton);
        helpButton = findViewById(R.id.helpButton);
        helpButton2 = findViewById(R.id.helpButton2);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mImageButton = findViewById(R.id.clickImageButton);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.START);
            }
        });

        complainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "complain Button", Toast.LENGTH_SHORT).show();
                Intent splashIntent = new Intent(MainActivity.this, ComplainActivity.class);
                startActivity(splashIntent);
            }
        });

        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "info Button", Toast.LENGTH_SHORT).show();
                Intent splashIntent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(splashIntent);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent splashIntent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(splashIntent);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent splashIntent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(splashIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_thana) {
            Intent i = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_mapview) {
            Intent i = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_complain) {
            Intent i = new Intent(MainActivity.this, ComplainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_help) {
            Intent i = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(i);

        }

        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
