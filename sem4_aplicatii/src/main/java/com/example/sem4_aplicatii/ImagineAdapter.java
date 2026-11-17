package com.example.sem4_aplicatii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {

    private Context context;
    private int resursaLayout;
    private List<ImaginiDomeniu> lista;

    public ImagineAdapter(Context context, int resursaLayout, List<ImaginiDomeniu> lista) {
        this.context = context;
        this.resursaLayout = resursaLayout;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(resursaLayout, parent, false);

        ImageView imagineIV = v.findViewById(R.id.imagineIV);
        TextView descriereTV = v.findViewById(R.id.descriereTV);

        ImaginiDomeniu element = lista.get(position);
        imagineIV.setImageBitmap(element.getImagine());
        descriereTV.setText(element.getTextAfisat());

        return v;
    }
}