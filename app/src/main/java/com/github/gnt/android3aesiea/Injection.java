package com.github.gnt.android3aesiea;

import com.github.gnt.android3aesiea.model.RestPokemonResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

    static final String BASE_URL = "https://pokeapi.co/api/v2/";

    public static PokemonRestApi getRestApiInstance(){
        com.github.gntGson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(PokemonRestApi.class);
    }
}
