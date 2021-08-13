package com.example.akaka;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;



public class NavDrawer extends AppCompatActivity {
   private DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);

        drawerLayout  = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(findViewById(R.id.toolBar));
        toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

              int id = menuItem.getItemId();
                Fragment fragment = null;
              switch (id){
                  case R.id.home:
                      fragment = new HomeFragment();
                      loadFragment(fragment);
                      break;

                  case R.id.message:
                      fragment = new MessageFragment();
                      loadFragment(fragment);
                      break;

                  case R.id.profile:
                      fragment = new ProfileFragment();
                      loadFragment(fragment);
                      break;

                  case R.id.send:
                      fragment = new SendFragment();
                      loadFragment(fragment);
                      break;
                  case R.id.exit:
                      fragment = new ExitFragment();
                      loadFragment(fragment);
                      break;

                  default:
                      return true;
              }
              return true;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}