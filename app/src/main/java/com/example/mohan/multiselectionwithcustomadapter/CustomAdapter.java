package com.example.mohan.multiselectionwithcustomadapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<String> counteryList = new ArrayList<String>();
    private Context context;
    private boolean isSelected[];

    public CustomAdapter(Context context, ArrayList<String> counteryList) {
        this.context = context;
        this.counteryList = counteryList;
        isSelected = new boolean[counteryList.size()];
    }

    @Override
    public int getCount() {
        return counteryList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_listview, null);
            holder = new ViewHolder();
            holder.relativeLayout = view.findViewById(R.id.row_relative_layout);
            holder.checkedTextView = view.findViewById(R.id.row_list_checkedtextview);
            holder.checkedImage = view.findViewById(R.id.row_list_checkbox_image);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.checkedTextView.setText(counteryList.get(position));
        holder.checkedImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.tick_unselelcted_ico));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set the check text view
                boolean flag = holder.checkedTextView.isChecked();
                holder.checkedTextView.setChecked(!flag);
                isSelected[position] = !isSelected[position];

                if (holder.checkedTextView.isChecked()) {
                    holder.checkedImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.tick_ico));
                    holder.relativeLayout.setBackgroundColor(Color.parseColor("#F16585"));
                } else {
                    holder.checkedImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.tick_unselelcted_ico));
                    holder.relativeLayout.setBackgroundResource(0);
                }
            }
        });

        return view;
    }

    public boolean[] getSelectedFlags() {
        return isSelected;
    }

    private class ViewHolder {
        RelativeLayout relativeLayout;
        CheckedTextView checkedTextView;
        ImageView checkedImage;
    }

}
