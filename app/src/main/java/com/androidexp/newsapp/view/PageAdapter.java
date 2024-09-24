package com.androidexp.newsapp.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.androidexp.newsapp.view.fragments.HomeFragment;
import com.androidexp.newsapp.view.fragments.SportsFragment;

public class PageAdapter extends FragmentPagerAdapter {
    int tabCount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                SportsFragment fragment = new SportsFragment();
                fragment.setCategory("sports");
                return fragment;
            case 2:
                SportsFragment fragment1 = new SportsFragment();
                fragment1.setCategory("health");
                return fragment1;
            case 3:
                SportsFragment fragment2 = new SportsFragment();
                fragment2.setCategory("science");
                return fragment2;
            case 4:
                SportsFragment fragment3 = new SportsFragment();
                fragment3.setCategory("entertainment");
                return fragment3;
            case 5:
                SportsFragment fragment4 = new SportsFragment();
                fragment4.setCategory("entertainment");
                return fragment4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
