package com.github.gnt.android3aesiea.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.gnt.android3aesiea.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView test1;
    public TextView text2;
    public View vue;

    public ViewHolder(View v) {
        super(v);
        vue = v;
        test1 = (TextView) v.findViewById(R.id.firstLine);
        text2 = (TextView) v.findViewById(R.id.secondLine);
    }
}
