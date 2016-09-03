package rejasupotaro.mds.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.Model;
import rejasupotaro.mds.data.models.PokemonDetail;
import rejasupotaro.mds.data.models.PokemonSnippet;
import rejasupotaro.mds.view.Transition;
import rejasupotaro.mds.view.components.PokemonProfileHeaderView;
import rejasupotaro.mds.view.components.StatListView;
import rejasupotaro.mds.view.fragments.BaseStatsFragment;
import rejasupotaro.mds.view.fragments.Fragments;
import rejasupotaro.mds.view.fragments.PokemonDetailListFragment;

public class PokemonProfileActivity extends BaseActivity {
    public static final String EXTRA_POKEMON = "pokemonSnippet";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.base_stats)
    StatListView baseStatsView;

    public static void launch(Activity activity, PokemonDetail pokemonDetail, Transition transition) {
        Intent intent = new Intent(activity, PokemonProfileActivity.class);
        intent.putExtra(EXTRA_POKEMON, pokemonDetail.toJson());
        Transition.putTransition(intent, transition);
        activity.startActivity(intent);
        transition.overrideOpenTransition(activity);
    }

    @Override
    public void finish() {
        super.finish();
        Transition.getTransition(getIntent()).overrideCloseTransition(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pokemon_profile_allinone);
        ButterKnife.bind(this);
        PokemonDetail pokemonDetail = Model.fromJson(getIntent().getStringExtra(EXTRA_POKEMON), PokemonDetail.class);

        setupActionBar();
        setupViews(pokemonDetail);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void setupViews(PokemonDetail pokemonDetail) {
        baseStatsView.setStats(pokemonDetail);
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


}
