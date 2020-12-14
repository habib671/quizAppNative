package com.example.quizappnative.adapterModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quizappnative.R;

public class MyListAdapter extends ArrayAdapter<String> {

    Context mContext;
    int[] mImages;
    String[] mNames;
    String[] mLinks;

    public MyListAdapter(@NonNull Context context, int[] images, String[] names, String[] links) {
        super(context, R.layout.list_view_layout);
        mContext = context;
        mImages = images;
        mNames = names;
        mLinks = links;
    }

    static class MyViewHolder {
        ImageView imageView;
        TextView textView;
    }

    @Override
    public int getCount() {
        return mNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MyViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.list_view_layout, parent, false);
            holder = new MyViewHolder();
            holder.imageView = convertView.findViewById(R.id.ques_image);
            holder.textView = convertView.findViewById(R.id.ques_name);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(mImages[position]);
        holder.textView.setText(mNames[position]);
        return convertView;
    }
}
