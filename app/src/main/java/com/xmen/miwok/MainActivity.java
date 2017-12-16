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

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(getTabIcon(i));
        }

    }

    private int getTabIcon(int position) {
        switch (position) {
            case 0: return R.drawable.ic_format_list_numbered_white_24dp;
            case 1: return R.drawable.ic_account_circle_white_24dp;
            case 2: return R.drawable.ic_invert_colors_white_24dp;
            case 3: return R.drawable.ic_textsms_white_24dp;
            default: return -1;
        }
    }
}
