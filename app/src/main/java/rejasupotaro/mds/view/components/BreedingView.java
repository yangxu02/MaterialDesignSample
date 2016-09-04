package rejasupotaro.mds.view.components;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.Breeding;
import rejasupotaro.mds.data.models.PokemonDetail;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BreedingView extends FrameLayout {
    @Bind(R.id.breeding_container)
    LinearLayout breedingContainer;

    public BreedingView(Context context) {
        super(context);
        setup();
    }

    public BreedingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public BreedingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_breeding, this);
        ButterKnife.bind(this);
    }

    private String toPercent(float value) {
        NumberFormat format = DecimalFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);
        return format.format(value);
    }

    public void setBreedingAttr(PokemonDetail pokemonDetail) {
        Breeding breeding = pokemonDetail.breeding();
        Context context = getContext();
        String eggGroups = TextUtils.join(", ", breeding.eggGroups());
        breedingContainer.addView(new AttrView(context).setup("EggGroups", eggGroups));
        String gender = "male " + toPercent(breeding.chanceMale()) + ", female " + toPercent(breeding.chanceFemale());
        breedingContainer.addView(new AttrView(context).setup("Gender", gender));
        String eggCycles = breeding.eggCycles() + "(" + breeding.eggCyclesComment() + ")";
        breedingContainer.addView(new AttrView(context).setup("EggCycles", eggCycles));
    }
}
