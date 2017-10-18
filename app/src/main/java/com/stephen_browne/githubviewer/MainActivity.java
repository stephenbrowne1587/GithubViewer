package com.stephen_browne.githubviewer;

import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    public SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager viewPager;
    public boolean loggedIn = false;
    public AppBarLayout mainAppbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appBarLayout = (AppBarLayout)findViewById(R.id.appbar_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mainAppbar = (AppBarLayout)findViewById(R.id.main_appbar);


//        ProfileFragment fragment = new ProfileFragment();
////        fragment.object = profileJSON;
//        FragmentTransaction ft = getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.main_content, fragment, "fragment")
//                .addToBackStack(null);
//        ft.commit();


//        SearchFragment fragment = new SearchFragment();
//        FragmentTransaction ft = getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.viewPager, fragment, "fragment")
//                .addToBackStack(null);
//        ft.commit();
        setupPagerAdapter();
//        setupTabbarIcons();

    }
    public void setupPagerAdapter() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(mSectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
    }
    public void setupTabbarIcons() {

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.search);
        tabLayout.getTabAt(1).setIcon(R.drawable.profile);
        mainAppbar.setVisibility(View.VISIBLE);

    }
}
