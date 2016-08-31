package rejasupotaro.mds.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.BaseStat;
import rejasupotaro.mds.data.models.BaseStats;
import rejasupotaro.mds.data.models.PokemonDetail;
import rejasupotaro.mds.view.components.StatView;

public class BaseStatsFragment extends Fragment {

    @Bind(R.id.hp)
    StatView hp;

    @Bind(R.id.attack)
    StatView attack;

    @Bind(R.id.defense)
    StatView defense;

    @Bind(R.id.sp_attack)
    StatView sp_attack;

    @Bind(R.id.sp_defense)
    StatView sp_defense;

    @Bind(R.id.speed)
    StatView speed;

    BaseStats baseStats;

    private final static String EXTRA_STATS = "extra_stats";

    public static BaseStatsFragment newInstance(Context context, PokemonDetail pokemonDetail) {
        BaseStatsFragment fragment = new BaseStatsFragment();
        Bundle stats = new Bundle();
        stats.putString(EXTRA_STATS, pokemonDetail.stats().toJson());
        fragment.setArguments(stats);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.baseStats = BaseStats.fromJson(getArguments().getString(EXTRA_STATS), BaseStats.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_stats, container, false);
        ButterKnife.bind(this, view);
        setupViews();
        return view;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    private void setupViews() {
        BaseStats.StatsDetail normal = baseStats.normal();
        Context context = getActivity();
        this.hp = new StatView(context, BaseStat.create(normal.hp(), BaseStat.Icon.HP));
        this.attack = new StatView(context, BaseStat.create(normal.attack(), BaseStat.Icon.ATTACK));
        this.defense = new StatView(context, BaseStat.create(normal.defense(), BaseStat.Icon.DEFENSE));
        this.sp_attack = new StatView(context, BaseStat.create(normal.spAttack(), BaseStat.Icon.SP_ATTACK));
        this.sp_defense = new StatView(context, BaseStat.create(normal.spDefense(), BaseStat.Icon.SP_DEFENSE));
        this.speed = new StatView(context, BaseStat.create(normal.speed(), BaseStat.Icon.SPEED));
    }
}
