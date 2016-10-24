package ru.solandme.holidays.adapters;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.solandme.holidays.data.Holiday;
import ru.solandme.holidays.HolidayDetailFragment;
import ru.solandme.holidays.R;
import ru.solandme.holidays.data.ApiRepository;

public class HolidaysRVAdapter extends RecyclerView.Adapter<HolidaysRVAdapter.MyViewHolder> {

    private ArrayList<Holiday> holidays;

    class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView holidayName;
        TextView holidayDescription;

        MyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            holidayName = (TextView) itemView.findViewById(R.id.holiday_name);
            holidayDescription = (TextView) itemView.findViewById(R.id.holidayDescription);
        }
    }

    public HolidaysRVAdapter(ArrayList<Holiday> holidays) {
        this.holidays = holidays;
//        holidays = ApiRepository.getHolidaysByPage(page);
    }

    public void add(int position, Holiday holiday) {
        holidays.add(position, holiday);
        notifyItemInserted(position);
    }

    public void remove(Holiday holiday) {
        int position = holidays.indexOf(holiday);
        holidays.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public HolidaysRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final HolidaysRVAdapter.MyViewHolder holder, final int position) {

        holder.holidayName.setText(holidays.get(position).getName());
        holder.holidayDescription.setText(holidays.get(position).getDescription());

        holder.cardView.setOnClickListener(view -> {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            HolidayDetailFragment holidayDetailFragment = new HolidayDetailFragment();
            Bundle bundle = new Bundle();
            bundle.getString("holidayName", holidays.get(position).getName());
            holidayDetailFragment.setArguments(bundle);
            if (activity.findViewById(R.id.containerB) != null){
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerB, holidayDetailFragment, "detailsHoliday")
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            } else {
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerA, holidayDetailFragment, "detailsHoliday")
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return holidays.size();
    }

}
