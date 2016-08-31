package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class PokeDex extends Model {
    @JsonProperty("national")
    public abstract int national();

    @JsonProperty("type")
    public abstract PokemonType[] type();

    @JsonProperty("species")
    public abstract String species();

    @JsonProperty("height")
    public abstract float height(); // m

    @JsonProperty("weight")
    public abstract float weight(); // kg

    @JsonProperty("abilities")
    public abstract PokemonAbility[] abilities();

    @JsonProperty("locals")
    public abstract int[] locals();

    @JsonProperty("aliasInJapanese")
    public abstract String aliasInJapanese();
}
