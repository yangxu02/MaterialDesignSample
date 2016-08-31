package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.Map;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class TypeDefense extends Model {

    @JsonProperty("effects")
    public abstract Map<PokemonType, Integer> effects();


}
