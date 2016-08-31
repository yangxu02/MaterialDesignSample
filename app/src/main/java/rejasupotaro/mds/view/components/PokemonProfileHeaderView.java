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
import rejasupotaro.mds.data.models.MaterialSource;
import rejasupotaro.mds.data.models.PokemonSnippet;

public class PokemonProfileHeaderView extends FrameLayout {

    @Bind(R.id.pokemon_image)
    ImageView pokemonImageView;
    @Bind(R.id.pokemon_name_text)
    TextView pokemonNameTextView;

    public PokemonProfileHeaderView(Context context) {
        super(context);
        setup();
    }

    public PokemonProfileHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public PokemonProfileHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_pokemon_profile_header, this);
        ButterKnife.bind(this);
    }

    public void setPokemon(PokemonSnippet pokemon) {
        String imageUrl = MaterialSource.PokemonWrapper.imageUrl(pokemon);
        Picasso.with(getContext()).load(imageUrl).into(pokemonImageView);
        pokemonNameTextView.setText(pokemon.name());
    }
}
