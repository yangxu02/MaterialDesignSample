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
    public abstract List<Pokemon> pokemons();

    @JsonCreator
    public static Channel create(@JsonProperty("name") String name,
                                 @JsonProperty("pokemons") List<Pokemon> pokemons) {
        return new AutoValue_Channel(name, pokemons);

    }

    public static Channel items() {
        return new AutoValue_Channel("Channel", Pokemons.allPokemons());
    }
}
