package com.github.gnt.android3aesiea.view;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.gnt.android3aesiea.R;
import com.github.gnt.android3aesiea.model.Pokemon;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Pokemon> valeur;

    public void add(int position, Pokemon item) {
        valeur.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        valeur.remove(position);
        notifyItemRemoved(position);
    }

     
    public MyAdapter(List<Pokemon> myDataset) {
        valeur = myDataset;
    }

     
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
         
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
         
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

     
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
         
         
        final Pokemon pokemonActuel = valeur.get(position);
        holder.txtFirstLine.setText(pokemonActuel.getName());
        holder.txtFooter.setText("Footer: " + pokemonActuel.getName());
    }

     
    @Override
    public int getItemCount() {
        return valeur.size();
    }

}
