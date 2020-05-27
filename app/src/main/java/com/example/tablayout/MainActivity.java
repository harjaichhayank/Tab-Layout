package com.example.tablayout;

import android.os.Bundle;

import com.example.tablayout.ui.main.HomeFragment;
import com.example.tablayout.ui.main.TopFreeFragment;
import com.example.tablayout.ui.main.TopPaidFragment;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tablayout.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.ViewPager);
        tabLayout = findViewById(R.id.TabLayout);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragments(new HomeFragment(), "Home Fragment");
        sectionsPagerAdapter.addFragments(new TopFreeFragment(), "Top Free Fragment");
        sectionsPagerAdapter.addFragments(new TopPaidFragment(), "Top Paid Fragment");
        viewPager.setAdapter(sectionsPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}