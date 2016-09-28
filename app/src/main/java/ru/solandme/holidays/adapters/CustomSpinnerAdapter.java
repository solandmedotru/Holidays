package ru.solandme.holidays.adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.solandme.holidays.R;

public class CustomSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    private final Context context;
    private int[] flags;
    private String[] countriesList;
    LayoutInflater inflater;

    public CustomSpinnerAdapter(Context context, int[] flags, String[] countriesList) {
        this.context = context;
        this.flags = flags;
        this.countriesList = countriesList;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.custom_spinner_items, null);
        ImageView flagIcon = (ImageView) view.findViewById(R.id.splashFlagIcon);
        TextView countryName = (TextView) view.findViewById(R.id.splashCountryName);

        flagIcon.setImageResource(flags[position]);
        countryName.setText(countriesList[position]);

        return view;
    }
}
