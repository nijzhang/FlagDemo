package com.example.a15625.flagdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyBaseAdapter extends ArrayAdapter {

    ArrayList<Item> arrayList = new ArrayList<>();
    public MyBaseAdapter(Context context,int textViewResourceId, ArrayList<Item> arrayList)
    {
        super(context,textViewResourceId,arrayList);
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = mInflater.inflate(R.layout.flag,null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView);

        textView.setText(arrayList.get(position).getName());
        imageView.setImageResource(arrayList.get(position).getImageId());

        return v;
    }
}
