package rejasupotaro.mds.view.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.MaterialSource;
import rejasupotaro.mds.data.models.PokemonSnippet;

public class PokemonDetailView extends FrameLayout {

    @Bind(R.id.pokemon_image)
    ImageView pokemonImageView;
    @Bind(R.id.title_wrapper)
    View titleWrapperView;
    @Bind(R.id.title_text)
    TextView titleTextView;
    @Bind(R.id.updated_at_text)
    TextView updatedAtTextView;
    @Bind(R.id.description_text)
    TextView descriptionTextView;
    @Bind(R.id.step_list)
    StepListView stepListView;
    @Bind(R.id.recipe_user)
    RecipeUserView recipeUserView;

    private Callback callback = new Callback() {
        @Override
        public void onSuccess() {
            Bitmap bitmap = ((BitmapDrawable) pokemonImageView.getDrawable()).getBitmap();
            new Palette.Builder(bitmap)
                .generate(palette -> {
                    int darkMutedColor = palette.getDarkMutedColor(R.color.text_color_primary);
                    titleWrapperView.setBackgroundColor(darkMutedColor);
                    int vibrantColor = palette.getVibrantColor(android.R.color.white);
                    titleTextView.setTextColor(vibrantColor);
                    int lightVibrantColor = palette.getLightVibrantColor(R.color.text_color_tertiary);
                    updatedAtTextView.setTextColor(lightVibrantColor);
                });
        }

        @Override
        public void onError() {

        }
    };

    public PokemonDetailView(Context context) {
        super(context);
        setup();
    }

    public PokemonDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_pokemon_detail, this);
        ButterKnife.bind(this);
    }

    public void setPokemon(PokemonSnippet pokemonSnippet) {
        String imageUrl = MaterialSource.PokemonWrapper.imageUrl(pokemonSnippet);
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(getContext())
                .load(imageUrl)
                .into(pokemonImageView, callback);
        }

        titleTextView.setText(pokemonSnippet.name());
        updatedAtTextView.setText("updateAt");
        descriptionTextView.setText("description");
        stepListView.setSteps(Collections.EMPTY_LIST);
    }
}
