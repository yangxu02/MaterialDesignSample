package rejasupotaro.mds.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.squareup.picasso.Picasso;
import org.apache.commons.lang3.StringUtils;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.BaseStat;

public class StatView extends FrameLayout {
    @Bind(R.id.stat_bar)
    ProgressBar statBar;
    @Bind(R.id.stat_name)
    TextView statNameText;


    public StatView(Context context) {
        super(context);
        setup();
    }

    public StatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public StatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public StatView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_stat, this);
        ButterKnife.bind(this);
    }

    public StatView setup(BaseStat stat) {
//        Picasso.with(getContext())
//            .load(stat.icon().icon()).into(statIcon);
        statBar.setProgress(stat.value());
        // TODO
        statBar.setMax(100);
        String name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, stat.icon().name());
        statNameText.setText(name);
        return this;
    }
}
