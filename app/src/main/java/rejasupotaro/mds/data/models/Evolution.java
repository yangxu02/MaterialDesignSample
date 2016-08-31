package rejasupotaro.mds.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/31.
 */
@AutoValue
public abstract class Evolution extends Model {
    @JsonProperty("upstreams")
    public abstract int[] upstreams();

    @JsonProperty("downstreams")
    public abstract int[] downstreams();
}
