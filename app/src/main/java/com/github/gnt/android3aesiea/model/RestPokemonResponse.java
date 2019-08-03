package com.github.gnt.android3aesiea.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestPokemonResponse {
    private Integer count;
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }
}
