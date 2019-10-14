package com.themtgdeckgenius.giphysearchjava;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.themtgdeckgenius.giphysearchjava.typedefs.RatingDefinition;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private Spinner mMenuSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        MenuItem item = menu.findItem(R.id.rating_spinner);
        mMenuSpinner = (Spinner) MenuItemCompat.getActionView(item);
        List<String> categories = new ArrayList<>();
        categories.add("Select Rating");
        categories.add(RatingDefinition.RATING_G);
        categories.add(RatingDefinition.RATING_PG);
        categories.add(RatingDefinition.RATING_PG_13);
        categories.add(RatingDefinition.RATING_R);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMenuSpinner.setAdapter(dataAdapter);
        return super.onCreateOptionsMenu(menu);
    }

    public String getRating(){
       String selectedRating = (String) mMenuSpinner.getSelectedItem();
       if (selectedRating.equals("Select Rating")){
           return "G";
       } else {
           return selectedRating;
       }
    }
}
