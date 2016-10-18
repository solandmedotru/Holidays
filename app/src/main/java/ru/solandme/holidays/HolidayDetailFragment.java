package ru.solandme.holidays;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HolidayDetailFragment extends Fragment {
    String holidayName;


    public HolidayDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            holidayName = savedInstanceState.getString("holidayName");
        }

        return inflater.inflate(R.layout.fragment_holiday_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.textViewInContainerB);
        textView.setText(holidayName);
    }
}
