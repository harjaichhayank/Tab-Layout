package com.example.tablayout.ui.main;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tablayout.R;
import com.example.tablayout.ViewPagerAdapter;

import java.util.Objects;

public class OffersFragment extends Fragment {

    private int dotsCount;
    private ImageView[] dots;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_offers, container, false);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getActivity());
        ViewPager viewPager = view.findViewById(R.id.ViewPagerId);
        viewPager.setAdapter(viewPagerAdapter);

        LinearLayout sliderDotsPanel = view.findViewById(R.id.SliderDotsId);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this.getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(this.getActivity()),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);
            sliderDotsPanel.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(this.getActivity(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) { }});

        return view;
    }
}
