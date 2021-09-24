package org.dev.fhhf.urlpkmimg.model;

public class ResponseObject {
    String pokemonUrl;

    public ResponseObject(String pokemonUrl) {
        this.pokemonUrl = pokemonUrl;
    }

    public String getPokemonUrl() {
        return pokemonUrl;
    }

    public void setPokemonUrl(String pokemonUrl) {
        this.pokemonUrl = pokemonUrl;
    }
}
