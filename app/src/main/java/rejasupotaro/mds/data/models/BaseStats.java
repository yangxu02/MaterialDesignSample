package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class BaseStats extends Model {

    @JsonProperty("normal")
    public abstract StatsDetail normal();

    @JsonProperty("min")
    public abstract StatsDetail min();

    @JsonProperty("max")
    public abstract StatsDetail max();

    @AutoValue
    public static abstract class StatsDetail extends Model {
        @JsonProperty("hp")
        public abstract int hp();

        @JsonProperty("attack")
        public abstract int attack();

        @JsonProperty("defense")
        public abstract int defense();

        @JsonProperty("spAttack")
        public abstract int spAttack();

        @JsonProperty("spDefense")
        public abstract int spDefense();

        @JsonProperty("speed")
        public abstract int speed();
    }
}
