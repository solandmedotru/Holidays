package ru.solandme.holidays.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.solandme.holidays.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String[] dataSet;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView holidayName;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            holidayName = (TextView) itemView.findViewById(R.id.holiday_name);
        }
    }

    public MyAdapter(int page) {
        if (page == 0){
            dataSet = new String[]{"asdasdasdas", "sdfds", "sdfsdfdsfsdf"};
        }
        if (page == 1){
            dataSet = new String[]{"asdadsaxczassdsdasdas", "sdfsadasdds", "sdfasdadssdfdsfsdf"};
        }
        if (page == 2){
            dataSet = new String[]{"asda545sdasdas", "sd46456fds", "sdfsd456456fdsfsdf"};
        }
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

        holder.holidayName.setText(dataSet[position]);

    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }


}