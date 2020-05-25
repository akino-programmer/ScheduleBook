package com.example.akira.schedulebook;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by akira on 2020/04/27.
 */

public class ScheduleAdapter extends RealmBaseAdapter<Schedule>{

    private int[] images = {R.drawable.image0
                 , R.drawable.image1
                 , R.drawable.image2};

    public ScheduleAdapter(@Nullable OrderedRealmCollection<Schedule> data) {
        super(data);
    }

    private static class ViewHolder {
        ImageView cardImage;
        TextView date;
        TextView title;
        TextView detail;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.custom_cell, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.cardImage = (ImageView) convertView.findViewById(R.id.card_image);


            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.detail =
                    (TextView) convertView.findViewById(R.id.detail);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Schedule schedule = adapterData.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate =sdf.format(schedule.date);
        viewHolder.date.setText(formatDate);
        viewHolder.title.setText(schedule.title);
        viewHolder.cardImage.setImageResource(images[(int) schedule.id % 3]);
        viewHolder.detail.setText(schedule.detail);

        return convertView;
    }
}
