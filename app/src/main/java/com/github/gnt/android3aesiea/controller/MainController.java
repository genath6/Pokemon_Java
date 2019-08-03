package com.github.gnt.android3aesiea.controller;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.github.gnt.android3aesiea.vue.MainActivity;
import com.github.gnt.android3aesiea.PokemonRestApi;
import com.github.gnt.android3aesiea.model.Pokemon;
import com.github.gnt.android3aesiea.model.RestPokemonResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity vue;

    private PokemonRestApi pokeApi;
 
    private SharedPreferences cacheData;

    public MainController(MainActivity vue, PokemonRestApi pokeApi, SharedPreferences cacheData) {
        this.vue = vue;
        this.pokeApi = pokeApi;
        this.cacheData = cacheData;
    }

    public void start() {
        Call<RestPokemonResponse> call = pokeApi.getPokemonList();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                if(response.isSuccessful()) {
                    RestPokemonResponse restPokemonResponse = response.body();
                    List<Pokemon> listePokemon = restPokemonResponse.getResults();
                    storeData(listePokemon);
                    vue.showList(listePokemon);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                List<Pokemon> listePokemon = getDataFromCache();
                vue.showList(listePokemon);
            }
        });
    }

    private void storeData(List<Pokemon> listePokemon) {
        Gson gson = new Gson();
        String listPokemonString = gson.toJson(listePokemon);
        cacheData
                .edit()
                .putString("keyStr", listPokemonString)
                .apply();
    }

    private List<Pokemon> getDataFromCache() {
        String listPokemonString = cacheData.getString("keyStr", "");
        if(listPokemonString != null && !TextUtils.isEmpty(listPokemonString)){
            Type listType = new TypeToken<List<Pokemon>>(){}.getType();
            List<Pokemon> listePokemon = new Gson().fromJson(listPokemonString, listType);
            return listePokemon;
        }
        return new ArrayList<>();
    }
}
