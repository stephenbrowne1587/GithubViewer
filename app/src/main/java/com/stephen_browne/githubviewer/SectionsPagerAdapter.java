package com.stephen_browne.githubviewer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by steph on 10/17/2017.
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    MainActivity mainActivity;

    public SectionsPagerAdapter(FragmentManager fm, MainActivity mainActivity) {
        super(fm);
        this.mainActivity = mainActivity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return SearchFragment.newInstance(position);
            case 1:
                return ProfileFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (mainActivity.loggedIn){
            return 2;
        }
        return 1;
    }
}
