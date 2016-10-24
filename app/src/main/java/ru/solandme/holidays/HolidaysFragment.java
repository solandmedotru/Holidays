package ru.solandme.holidays;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.solandme.holidays.adapters.HolidayTabFragmentPagerAdapter;

public class HolidaysFragment extends Fragment {
    HolidayTabFragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
//    int currentTab;

    public HolidaysFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentPagerAdapter = new HolidayTabFragmentPagerAdapter(getChildFragmentManager(), getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        if (savedInstanceState != null) {
//            currentTab = savedInstanceState.getInt("currentTab");
//        }

        return inflater.inflate(R.layout.fragment_holidays, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = (ViewPager) view.findViewById(R.id.main_view_pager);
        viewPager.setAdapter(fragmentPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.main_sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
