package com.example.ex3.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ex3.fragment.HomeFragment;
import com.example.ex3.fragment.SearchFragment;
import com.example.ex3.fragment.UserFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();

            case 1:
                return new SearchFragment();

            case 2:
                return new UserFragment();

            default:
                return new HomeFragment();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Home";
                break;

            case 1:
                title = "Search";
                break;

            case 2:
                title = "User";
                break;

        }
        return title;
    }
}
