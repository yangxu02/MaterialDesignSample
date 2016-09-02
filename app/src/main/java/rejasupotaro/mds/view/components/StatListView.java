package rejasupotaro.mds.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.List;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.BaseStat;

public class StatListView extends FrameLayout {
    @Bind(R.id.stats_container)
    LinearLayout statsContainer;

    public StatListView(Context context) {
        super(context);
        setup();
    }

    public StatListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public StatListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_stat_list, this);
        ButterKnife.bind(this);
    }

    public void setSteps(List<BaseStat> stats) {
        for (BaseStat stat : stats) {
            statsContainer.addView(new StatView(getContext()).setup(stat));
        }
    }
}
