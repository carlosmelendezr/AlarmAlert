package com.carlosintranets.alarmalert;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class EstatusAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Estatus> objects;

    private class ViewHolder {
        TextView genTextView1;
        TextView genTextView3;
        TextView genTextView4;
    }

    public EstatusAdapter(Context context, ArrayList<Estatus> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() {
        return objects.size();
    }

    public Estatus getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.estatus_generico, null);
            holder.genTextView1 = (TextView) convertView.findViewById(R.id.genTextView1);
            //holder.genTextView2 = (TextView) convertView.findViewById(R.id.genTextView2);
            holder.genTextView3 = (TextView) convertView.findViewById(R.id.genTextView3);
            holder.genTextView4 = (TextView) convertView.findViewById(R.id.genTextView4);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        int est = objects.get(position).getEstado();

        holder.genTextView1.setText(objects.get(position).getLocalidad());
        //holder.genTextView2.setText(objects.get(position).getEstado());
        holder.genTextView3.setText(objects.get(position).getFecha().toString());
        holder.genTextView4.setText(objects.get(position).getEvento());
        switch(est) {
            case 0: {
                convertView.setBackgroundColor(Color.GRAY);
                break;
            }
            case 1: {
                convertView.setBackgroundColor(Color.GREEN);
                break;
            }
            case 2: {
                convertView.setBackgroundColor(Color.RED);
                break;
            }
        }
        return convertView;
    }
}