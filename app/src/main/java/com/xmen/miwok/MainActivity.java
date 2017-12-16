package com.xmen.miwok;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigation();
    }

    // This method handles the navigation of the app
    private void setupNavigation() {

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.view_pager);

        // Create an adapter that knows which fragment should be shown on each page
        MainAppPagerAdapter adapter = new MainAppPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new NumbersFragment(), "Numbers");
        adapter.addFragment(new FamilyMembersFragment(), "Family");
        adapter.addFragment(new ColorsFragment(), "Colors");
        adapter.addFragment(new PhrasesFragment(), "Phrases");

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Setup the tabs
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
