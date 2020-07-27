package com.example.tablayout;

import android.os.Bundle;
import com.example.tablayout.ui.main.OffersFragment;
import com.example.tablayout.ui.main.DetailsFragment;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tablayout.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPager);
        tabLayout = findViewById(R.id.TabLayout);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),1);
        sectionsPagerAdapter.addFragments(new OffersFragment(), "Offers");
        sectionsPagerAdapter.addFragments(new DetailsFragment(), "Details");

        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}