package com.example.ujiatengahsemester;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class AdapterList extends ArrayAdapter<DataJob> {

    Context context;
    int resource;

    public AdapterList(Context context, int resource) {
        super(context, resource);

        this.context = context;
        this.resource = resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder = new Holder();
            holder.imageView = convertView.findViewById(R.id.companypic);
            holder.nama = convertView.findViewById(R.id.company_name);
            holder.posisi = convertView.findViewById(R.id.position);
            holder.lokasi = convertView.findViewById(R.id.location);
            holder.lastupdt = convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }


        holder.nama.setText(getItem(position).getPerusahaan());
        holder.posisi.setText(getItem(position).getPosisi());
        holder.lokasi.setText(getItem(position).getLokasi());
        holder.lastupdt.setText(getItem(position).getLastupdt());

        new getimageurl(holder.imageView).execute(getItem(position).getImageurl());


        return convertView;

    }

    class Holder {
        ImageView imageView;
        TextView nama;
        TextView posisi;
        TextView lokasi;
        TextView lastupdt;
    }
}
