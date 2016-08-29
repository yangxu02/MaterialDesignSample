package rejasupotaro.mds.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.Pokemon;
import rejasupotaro.mds.utils.DisplayUtils;
import rejasupotaro.mds.view.components.PokemonDetailView;

public class PokemonActivity extends BaseActivity {
    public static final String EXTRA_POKEMON = "pokemon";
    public static final String EXTRA_IMAGE = "ItemDetailActivity:image";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recipe_detail)
    PokemonDetailView pokemonDetailView;

    private Pokemon pokemon;

    public static void launch(Activity activity, Pokemon pokemon, ImageView transitionView, String url) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            activity,
            transitionView,
            EXTRA_IMAGE);

        Intent intent = new Intent(activity, PokemonActivity.class);
        intent.putExtra(EXTRA_POKEMON, pokemon.toJson());
        intent.putExtra(EXTRA_IMAGE, url);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        ButterKnife.bind(this);

        ImageView pokemonImageView = (ImageView) pokemonDetailView.findViewById(R.id.pokemon_image);
        ViewCompat.setTransitionName(pokemonImageView, EXTRA_IMAGE);

        pokemon = Pokemon.fromJson(getIntent().getStringExtra(EXTRA_POKEMON), Pokemon.class);

        setupActionBar();
        setupViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupActionBar() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
        layoutParams.setMargins(0, DisplayUtils.getStatusBarHeight(this), 0, 0);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void setupViews() {
        pokemonDetailView.setPokemon(pokemon);
    }
}
