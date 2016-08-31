package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class Channel extends Model {
    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("recipes")
    public abstract List<PokemonSnippet> pokemons();

    @JsonCreator
    public static Channel create(@JsonProperty("name") String name,
                                 @JsonProperty("pokemonSnippets") List<PokemonSnippet> pokemonSnippets) {
        return new AutoValue_Channel(name, pokemonSnippets);

    }

    public static Channel items() {
        return new AutoValue_Channel("Channel", Pokemons.allPokemons());
    }
}
