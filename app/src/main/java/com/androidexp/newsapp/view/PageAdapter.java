package com.androidexp.newsapp.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.androidexp.newsapp.view.fragments.EntertainmentFragment;
import com.androidexp.newsapp.view.fragments.HealthFragment;
import com.androidexp.newsapp.view.fragments.HomeFragment;
import com.androidexp.newsapp.view.fragments.ScienceFragment;
import com.androidexp.newsapp.view.fragments.SportsFragment;
import com.androidexp.newsapp.view.fragments.TechnologyFragment;

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
                SportsFragment sportsFragment = new SportsFragment();
                sportsFragment.setCategory("sports");
                return sportsFragment;
            case 2:
                SportsFragment sportsFragment2 = new SportsFragment();
                sportsFragment2.setCategory("health");
                return sportsFragment2;
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechnologyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
