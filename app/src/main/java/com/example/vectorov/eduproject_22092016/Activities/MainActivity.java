package com.example.vectorov.eduproject_22092016.Activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vectorov.eduproject_22092016.Config;
import com.example.vectorov.eduproject_22092016.Fragments.Fragment_store;
import com.example.vectorov.eduproject_22092016.R;
import com.example.vectorov.eduproject_22092016.StoreContract;
import com.example.vectorov.eduproject_22092016.StoreTest;
import com.example.vectorov.eduproject_22092016.ToolsContract;
import com.example.vectorov.eduproject_22092016.ToolsTest;

/**
 * Created by vectorov on 22.09.2016.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_contanier, new Fragment_store(), "fragment_store").commit();

        Cursor cursor = getContentResolver().query(Config.STORES_URI, null, null, null, null);
        if(cursor.getCount() == 0) {
            for (Object store : Config.getStoreData()) {
                StoreTest tmp = (StoreTest) store;
                ContentValues cv = new ContentValues();
                cv.put(StoreContract.name, tmp.getName());
                cv.put(StoreContract.phone, tmp.getPhone());
                cv.put(StoreContract.address, tmp.getAddress());
                getContentResolver().insert(Config.STORES_URI, cv);
            }
        }

        cursor = getContentResolver().query(Config.TOOLS_URI, null, null, null, null);
        if(cursor.getCount() == 0) {
            for (Object tools : Config.getToolsData()) {
                ToolsTest tmp = (ToolsTest) tools;
                ContentValues cv = new ContentValues();
                cv.put(ToolsContract.storeId, tmp.getStoreId());
                cv.put(ToolsContract.brand, tmp.getBrand());
                cv.put(ToolsContract.model, tmp.getModel());
                cv.put(ToolsContract.type, tmp.getType());
                cv.put(ToolsContract.imageUrl, tmp.getImageUrl());
                cv.put(ToolsContract.price, tmp.getPrice());
                cv.put(ToolsContract.quantity, tmp.getQuantity());
                getContentResolver().insert(Config.TOOLS_URI, cv);
            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            Fragment frTools = getSupportFragmentManager().findFragmentByTag("fragment_tools");
            if(frTools != null)
            {
                if(frTools.isVisible())
                {
                    Fragment fr = getSupportFragmentManager().findFragmentByTag("fragment_store");
                    if (fr == null)
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contanier, new Fragment_store()).commit();
                    else
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contanier, fr).commit();
                }
            }
            else
                super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
