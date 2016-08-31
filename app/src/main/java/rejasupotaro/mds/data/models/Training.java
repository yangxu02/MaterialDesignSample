package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class Training extends Model {
    @JsonProperty("evYield")
    public abstract String evYield();

    @JsonProperty("catchRate")
    public abstract float catchRate();

    @JsonProperty("catchRateComment")
    public abstract String catchRateComment();

    @JsonProperty("baseHappiness")
    public abstract int baseHappiness();

    @JsonProperty("baseExp")
    public abstract int baseExp();

    @JsonProperty("growthRate")
    public abstract String growthRate();
}
