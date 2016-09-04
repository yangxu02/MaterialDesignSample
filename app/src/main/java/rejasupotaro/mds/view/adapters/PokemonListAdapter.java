package rejasupotaro.mds.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import rejasupotaro.mds.R;
import rejasupotaro.mds.activities.PokemonProfileActivity;
import rejasupotaro.mds.data.models.MaterialSource;
import rejasupotaro.mds.data.models.PokemonSnippet;
import rejasupotaro.mds.view.Transition;

import java.util.List;

public class PokemonListAdapter extends BindableAdapter<PokemonSnippet> {
    public PokemonListAdapter(Context context, List<PokemonSnippet> pokemonSnippets) {
        super(context, pokemonSnippets);
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        View view = inflater.inflate(R.layout.list_item_pokemon, null, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(PokemonSnippet pokemonSnippet, int position, View view) {
        final ViewHolder holder = (ViewHolder) view.getTag();

        Picasso.with(view.getContext())
            .load(MaterialSource.PokemonWrapper.imageUrl(pokemonSnippet))
            .into(holder.pokemonImageView);

        holder.pokemonNameTextView.setText(pokemonSnippet.name());

        view.setOnClickListener(v -> {
            Activity activity = (Activity) v.getContext();
            PokemonProfileActivity.launch(activity, pokemonSnippet, Transition.PUSH_RIGHT_TO_LEFT);
        });
    }

    static class ViewHolder {
        @Bind(R.id.pokemon_image)
        ImageView pokemonImageView;
        @Bind(R.id.pokemon_name_text)
        TextView pokemonNameTextView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
