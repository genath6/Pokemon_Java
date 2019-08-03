package com.github.gnt.android3aesiea;

import com.github.gnt.android3aesiea.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonRestApi {
    @GET("pokemon/")
    Call<RestPokemonResponse> getPokemonList();
}
