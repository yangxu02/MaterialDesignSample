package rejasupotaro.mds.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.Evolution;
import rejasupotaro.mds.data.models.MaterialSource;
import rejasupotaro.mds.data.models.PokemonDetail;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class EvolutionView extends FrameLayout {
    @Bind(R.id.stage_pokemon_image)
    ImageView stageImageView;
    @Bind(R.id.stage_pokemon_name)
    TextView stageNameText;
    @Bind(R.id.stage_evolution_condition)
    TextView stageEvolutionText;

    public EvolutionView(Context context) {
        super(context);
        setup();
    }

    public EvolutionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public EvolutionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_evolution, this);
        ButterKnife.bind(this);
    }

    private String toPercent(float value) {
        NumberFormat format = DecimalFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);
        return format.format(value);
    }

    public EvolutionView setEvolutionStage(PokemonDetail pokemonDetail) {
        Evolution evolution = pokemonDetail.evolution();
        Context context = getContext();
        Picasso.with(context).load(MaterialSource.PokemonWrapper.imageUrl(pokemonDetail.snippet())).into(stageImageView);
        stageNameText.setText(pokemonDetail.snippet().name());
        stageEvolutionText.setText("All Conditions");
        return this;
    }
}
