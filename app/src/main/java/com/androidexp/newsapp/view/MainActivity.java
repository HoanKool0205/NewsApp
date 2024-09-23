package com.androidexp.newsapp.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.androidexp.newsapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    String api = "cdb9ea97ba0f44849041fac85d759081";

    TabLayout tabLayout;

    TextView tvNews;

    TabItem mHome, mSport, mHealth, mScience, mEntertainment, mTechnology;

    PageAdapter pageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNews = findViewById(R.id.tvNews);

        mHome = findViewById(R.id.homeBtn);
        mSport = findViewById(R.id.sportBtn);
        mHealth = findViewById(R.id.heathBtn);
        mScience = findViewById(R.id.scienceBtn);
        mEntertainment = findViewById(R.id.entertainmentBtn);
        mTechnology = findViewById(R.id.technologyBtn);

        tabLayout = findViewById(R.id.included);
        ViewPager viewPager = findViewById(R.id.fragment);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pageAdapter);
        viewPager.setOffscreenPageLimit(4);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        
    }
}