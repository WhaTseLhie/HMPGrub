package com.example.jayvee.hmpgrub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    HMPGrubDatabase jDatabase;
    ArrayList<Customer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        jDatabase = new HMPGrubDatabase(this);
        list = jDatabase.getAllLoggedInCustomer();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);

        TextView txtName = headerView.findViewById(R.id.textView);
        TextView txtUsername = headerView.findViewById(R.id.textView1);

        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(list.get(0).getCustomer_fname()).append(" ").append(list.get(0).getCustomer_lname());
        txtName.setText(builder);

        StringBuilder builder2 = new StringBuilder();
        builder2.append("Username: ").append(list.get(0).getCustomer_username());
        txtUsername.setText(builder2);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue:


                break;
            case R.id.green:


                break;
            case R.id.red:


                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                HomeFragment homeFragment = new HomeFragment();
                FragmentManager homeManager = getSupportFragmentManager();
                homeManager.beginTransaction().replace(
                        R.id.linearLayout,
                        homeFragment,
                        homeFragment.getTag()
                ).commit();

                break;

            case R.id.browse:
                BrowseFragment browseFragment = new BrowseFragment();
                FragmentManager browseManager = getSupportFragmentManager();
                browseManager.beginTransaction().replace(
                        R.id.linearLayout,
                        browseFragment,
                        browseFragment.getTag()
                ).commit();

                break;
            case R.id.favorite:
                FavoritesFragment favoritesFragment = new FavoritesFragment();
                FragmentManager favoritesManager = getSupportFragmentManager();
                favoritesManager.beginTransaction().replace(
                        R.id.linearLayout,
                        favoritesFragment,
                        favoritesFragment.getTag()
                ).commit();

                break;

            case R.id.order:
                OrderFragment orderFragment = new OrderFragment();
                FragmentManager orderManager = getSupportFragmentManager();
                orderManager.beginTransaction().replace(
                        R.id.linearLayout,
                        orderFragment,
                        orderFragment.getTag()
                ).commit();

                break;

            case R.id.notification:
                NotificationFragment notificationFragment = new NotificationFragment();
                FragmentManager notificationManager = getSupportFragmentManager();
                notificationManager.beginTransaction().replace(
                        R.id.linearLayout,
                        notificationFragment,
                        notificationFragment.getTag()
                ).commit();

                break;

            case R.id.review:
                ReviewsFragment reviewsFragment = new ReviewsFragment();
                FragmentManager reviewManager = getSupportFragmentManager();
                reviewManager.beginTransaction().replace(
                        R.id.linearLayout,
                        reviewsFragment,
                        reviewsFragment.getTag()
                ).commit();

                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
