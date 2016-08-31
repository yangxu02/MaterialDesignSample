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
import rejasupotaro.mds.view.fragments.BaseStatsFragment;
import rejasupotaro.mds.view.fragments.Fragments;
import rejasupotaro.mds.view.fragments.PokemonDetailListFragment;

public class PokemonProfileActivity extends BaseActivity {
    public static final String EXTRA_POKEMON = "pokemonSnippet";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.pokemon_profile_header)
    PokemonProfileHeaderView pokemonProfileHeaderView;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.pager_tabs)
    TabLayout tabLayout;

    PokemonDetail pokemonDetail;

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
        setContentView(R.layout.activity_pokemon_profile);
        ButterKnife.bind(this);
        PokemonDetail pokemonDetail = Model.fromJson(getIntent().getStringExtra(EXTRA_POKEMON), PokemonDetail.class);

        setupActionBar();
        setupViewPager(pokemonDetail);
        setupViews(pokemonDetail.snippet());
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private final static Map<String, Class<? extends Fragment>> pages
        = new ImmutableMap.Builder<String, Class<? extends Fragment>>()
        .put("Introduction", PokemonDetailListFragment.class)
        .put("Base Stats", BaseStatsFragment.class)
        .put("Training", PokemonDetailListFragment.class)
        .put("Breeding", PokemonDetailListFragment.class)
        .put("TypeDefense", PokemonDetailListFragment.class)
        .build();

    private void setupViewPager(PokemonDetail pokemonDetail) {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (Map.Entry<String, Class<? extends Fragment>> entry : pages.entrySet()) {
            Fragment fragment = Fragments.create(entry.getValue(), pokemonDetail);
            if (null == fragment) continue;
            pagerAdapter.addFragment(fragment, entry.getKey());
        }
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViews(PokemonSnippet pokemonSnippet) {
        pokemonProfileHeaderView.setPokemon(pokemonSnippet);
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

    private static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> titles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
