package ru.solandme.holidays;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.solandme.holidays.adapters.HolidaysRVAdapter;
import ru.solandme.holidays.data.ApiRepository;

public class PageFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    int page;

    HolidaysRVAdapter adapter;

    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_page, container, false);
        RecyclerView holidayRV = (RecyclerView) rootView.findViewById(R.id.holidayRecyclerView);

        adapter = new HolidaysRVAdapter(ApiRepository.getHolidaysByPage(page));
        holidayRV.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        holidayRV.setLayoutManager(linearLayoutManager);

        return rootView;
    }
}
