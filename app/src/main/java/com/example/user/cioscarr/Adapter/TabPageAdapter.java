package com.example.user.cioscarr.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentLst = new ArrayList<>();
    private final List<String> fragmentTitleLst = new ArrayList<>();

    public void addFragment(Fragment fragment,String title){
        fragmentLst.add(fragment);
        fragmentTitleLst.add(title);

    }

    public TabPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleLst.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentLst.get(i);
    }

    @Override
    public int getCount() {
        return fragmentLst.size();
    }
}
