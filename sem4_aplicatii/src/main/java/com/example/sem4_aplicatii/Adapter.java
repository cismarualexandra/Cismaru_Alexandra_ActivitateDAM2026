package com.example.sem4_aplicatii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private List<AMasina> masini = null;
    private Context ctx;
    private int resursaLayout;

    public Adapter(Context ctx, int resursaLayout, List<AMasina> masini) {
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
        this.masini = masini;
    }

    @Override
    public int getCount() {
        return masini.size();
    }

    @Override
    public Object getItem(int position) {
        return masini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent, false);

        TextView numeMarca = v.findViewById(R.id.tvMarca);
        TextView numeCombustibil = v.findViewById(R.id.tvCombustibil);
        TextView numeRating = v.findViewById(R.id.tvRating);
        TextView numeAutomata = v.findViewById(R.id.tvAutomata);
        TextView numeCuloare = v.findViewById(R.id.tvCuloare);


        AMasina m = masini.get(position);

        numeMarca.setText(m.getMarca());
        numeCuloare.setText(m.getCuloare());
        numeCombustibil.setText(m.getCombustibil());


        return v;
    }


}
