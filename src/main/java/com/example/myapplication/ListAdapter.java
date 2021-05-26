package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Model> {


    private Context activityContext;
    private List<Model> list;
    public static final String TAG = "ListView";

    public ListAdapter(Context context, List<Model> list){
        super(context, R.layout.list_part, list);
        this.activityContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Model getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View view, ViewGroup viewGroup){


        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_part, null);


            TextView nam = (TextView) view.findViewById(R.id.namee);
            TextView age = (TextView) view.findViewById(R.id.age);
            TextView inf = (TextView) view.findViewById(R.id.inform);
            TextView help = (TextView) view.findViewById(R.id.help);


            final Model model = (Model) this.getItem(position);

            nam.setText(model.getNam());
            age.setText(model.getAge());
            inf.setText(model.getInform());
            help.setText(model.getHelp());
        }

        return view;
    }

    private static class ViewHolder {

        TextView nam;
        TextView age;
        TextView inform;
        TextView help;
    }


}

