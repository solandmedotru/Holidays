package ru.solandme.holidays.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.solandme.holidays.DetailActivity;
import ru.solandme.holidays.Holiday;
import ru.solandme.holidays.R;
import ru.solandme.holidays.data.ApiRepository;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Holiday> holidays;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView holidayName;
        TextView holidayDescription;

        public MyViewHolder(final View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            holidayName = (TextView) itemView.findViewById(R.id.holiday_name);
            holidayDescription = (TextView) itemView.findViewById(R.id.holidayDescription);
        }
    }

    public MyAdapter(int page) {
        holidays = ApiRepository.getHolidaysByPage(page);
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHolder holder, final int position) {

        holder.holidayName.setText(holidays.get(position).getName());
        holder.holidayDescription.setText(holidays.get(position).getDescription());

        holder.cardView.setOnClickListener(view -> {
            Activity activity = (Activity) view.getContext();
            Intent intent = new Intent(activity, DetailActivity.class);
            intent.putExtra("position", holder.getAdapterPosition());

            activity.startActivity(intent);
            activity.overridePendingTransition(android.R.anim.fade_in,
                    android.R.anim.fade_out);
        });

    }

    @Override
    public int getItemCount() {
        return holidays.size();
    }

}
