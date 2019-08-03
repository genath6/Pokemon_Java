package com.github.gnt.android3aesiea.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.gnt.android3aesiea.Injection;
import com.github.gnt.android3aesiea.R;
import com.github.gnt.android3aesiea.controller.MainController;
import com.github.gnt.android3aesiea.model.Pokemon;

import java.util.List;

public class MainActivity extends Activity {
    
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MainController controller = new MainController(
                this,
                Injection.getRestApiInstance(),
                sharedPreferences);
        controller.start();
    }

    public void showList(List<Pokemon> pokemonList) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
         
        recyclerView.setHasFixedSize(true);
         
         
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
         

         
        mAdapter = new MyAdapter(pokemonList);
        recyclerView.setAdapter(mAdapter);
    }
}
