package rejasupotaro.mds.data.models;

import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class PokemonDetail extends Model {

    public abstract PokemonSnippet snippet();

    public abstract BaseStats stats();

    public abstract Breeding breeding();

    public abstract PokeDex dex();

    public abstract Training training();

    public abstract TypeDefense defense();

    public abstract NameOrigin nameOrigin();

    public abstract Evolution evolution();
}
