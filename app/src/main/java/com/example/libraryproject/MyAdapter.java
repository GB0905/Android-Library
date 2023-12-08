package com.example.libraryproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter { // 리스트 뷰의 어뎁터
    Context context;
    int layout;
    ArrayList<Books> bl;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<Books> bl) {
        this.context = context;
        this.layout = layout;
        this.bl = bl;
        inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bl.size();
    }
    @Override
    public Object getItem(int position) {
        return bl.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }

        ImageView Img = (ImageView)convertView.findViewById(R.id.bookimg);
        TextView Title = (TextView)convertView.findViewById(R.id.text_title);
        TextView Writer = (TextView)convertView.findViewById(R.id.text_writer);
        TextView Location = (TextView)convertView.findViewById(R.id.text_location);
        TextView Rentbook = (TextView)convertView.findViewById(R.id.text_rent);

        Books m = bl.get(position);
        Img.setImageResource(m.img);
        Title.setText(m.title);
        Writer.setText(m.writer);
        Location.setText(m.location);
        Rentbook.setText(m.rentbook);

        return convertView;
    }
}
