package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class Breeding extends Model {
    @JsonProperty("eggGroups")
    public abstract String[] eggGroups();

    @JsonProperty("chanceMale")
    public abstract float chanceMale();

    @JsonProperty("chanceFemale")
    public abstract float chanceFemale();

    @JsonProperty("eggCycles")
    public abstract int eggCycles();

    @JsonProperty("eggCyclesComment")
    public abstract int eggCyclesComment();

}
