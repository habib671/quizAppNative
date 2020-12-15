package com.example.quizappnative.adapterModels;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quizappnative.R;
import com.example.quizappnative.quizActivities.QuizQuestionActivity;

public class QuizSetsAdapter extends BaseAdapter {
    public QuizSetsAdapter(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    private final int numberOfSets;

    @Override
    public int getCount() {
        return numberOfSets;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_sets_layout, parent, false);
        } else {
            view = convertView;
        }
        view.setOnClickListener(view1 -> {
            Intent intent = new Intent(parent.getContext(), QuizQuestionActivity.class);
            intent.putExtra("SETNO", position + 1);
            parent.getContext().startActivity(intent);
        });
        ((TextView) view.findViewById(R.id.setsNumberTextView)).setText(String.valueOf(position + 1));

        //this random class will generate random things,in this case it will generate random colors for grid item
        /*Random random = new Random();
        int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
        view.setBackgroundColor(color);*/

        return view;
    }
}
