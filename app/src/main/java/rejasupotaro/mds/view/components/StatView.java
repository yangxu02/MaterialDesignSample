package rejasupotaro.mds.view.components;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.BaseStat;

public class StatView extends FrameLayout {
    @Bind(R.id.stat_icon)
    ImageView statIcon;
    @Bind(R.id.stat_bar)
    ProgressBar statBar;

    public StatView(Context context, BaseStat stat) {
        super(context);
        setup(stat);
    }

    private void setup(BaseStat stat) {
        inflate(getContext(), R.layout.view_stat, this);
        ButterKnife.bind(this);
        Picasso.with(getContext())
            .load(stat.icon().icon()).into(statIcon);
        statBar.setProgress(stat.value());
        // TODO
        statBar.setMax(100);
    }
}
