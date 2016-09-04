package rejasupotaro.mds.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.PokemonDetail;
import rejasupotaro.mds.view.adapters.PokemonDetailListAdapter;
import rejasupotaro.mds.view.components.DividerItemDecoration;

import java.util.Collections;

public class PokemonDetailListFragment extends Fragment {

    @Bind(R.id.scroll)
    RecyclerView pokemonDetailListView;

    private PokemonDetailListAdapter pokemonDetailListAdapter;

    public static Fragment newInstance(PokemonDetail pokemonDetail) {
        PokemonDetailListFragment fragment = new PokemonDetailListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_detail_list, container, false);
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
        pokemonDetailListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        pokemonDetailListView.setHasFixedSize(false);
        pokemonDetailListAdapter = new PokemonDetailListAdapter(Collections.EMPTY_LIST);
        pokemonDetailListView.addItemDecoration(new DividerItemDecoration(getActivity()));
        pokemonDetailListView.setAdapter(pokemonDetailListAdapter);
    }
}
