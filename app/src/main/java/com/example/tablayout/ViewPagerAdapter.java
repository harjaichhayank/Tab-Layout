package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private Integer[] images = {R.drawable.movie_1,R.drawable.movie_2,R.drawable.movie_3,
            R.drawable.movie_4,R.drawable.movie_5,R.drawable.movie_6,
            R.drawable.movie_7,R.drawable.movie_8,R.drawable.movie_9,
            R.drawable.movie_10,R.drawable.movie_11,R.drawable.movie_12};

    public ViewPagerAdapter(Context context) { this.context = context; }

    @Override
    public int getCount() { return images.length; }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) { return view == object; }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        final View view = layoutInflater.inflate(R.layout.custom_layout,container,false);

        final ImageView imageView = view.findViewById(R.id.ImageViewId);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "data is send " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}