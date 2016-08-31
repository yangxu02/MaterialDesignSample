package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import java.util.List;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class Breeding extends Model {
    @JsonProperty("eggGroups")
    public abstract List<String> eggGroups();

    @JsonProperty("chanceMale")
    public abstract float chanceMale();

    @JsonProperty("chanceFemale")
    public abstract float chanceFemale();

    @JsonProperty("eggCycles")
    public abstract int eggCycles();

    @JsonProperty("eggCyclesComment")
    public abstract int eggCyclesComment();

    @JsonCreator
    public static Breeding create(@JsonProperty("eggGroups") List<String> eggGroups,
                                  @JsonProperty("chanceMale") float chanceMale,
                                  @JsonProperty("chanceFemale") float chanceFemale,
                                  @JsonProperty("eggCycles") int eggCycles,
                                  @JsonProperty("eggCyclesComment") int eggCyclesComment) {
        return new AutoValue_Breeding(eggGroups, chanceMale, chanceFemale, eggCycles, eggCyclesComment);
    }



}
