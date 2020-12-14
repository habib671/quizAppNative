package com.example.quizappnative.adapterModels;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quizappnative.R;
import com.example.quizappnative.quizActivities.QuizSetsActivity;

import java.util.List;
import java.util.Random;

public class QuizCategoryGridAdapter extends BaseAdapter {

    private final List<String> catList;
    @Override
    public int getCount() {
        return catList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public QuizCategoryGridAdapter(List<String> catList) {
        this.catList = catList;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view;
        if(convertView == null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_category_layout,parent,false);
        }
        else{
            view = convertView;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(), QuizSetsActivity.class);
                intent.putExtra("CATEGORY",catList.get(position));//firebase cat
                intent.putExtra("CATEGORY_ID",position+1);//firebase set with position(start 0)
                parent.getContext().startActivity(intent);
            }
        });

        ( (TextView) view.findViewById(R.id.catName)).setText(catList.get(position));

        //this random class will generate random things, in this case it will generate random colors for grid item
        Random random = new Random();
        int color = Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255));
        view.setBackgroundColor(color);

        return view;
    }
}
