package ru.solandme.holidays.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.solandme.holidays.PageFragment;
import ru.solandme.holidays.R;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] tabTitles;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = new String[]{
                context.getString(R.string.tab1_name),
                context.getString(R.string.tab2_name),
                context.getString(R.string.tab3_name)};
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
