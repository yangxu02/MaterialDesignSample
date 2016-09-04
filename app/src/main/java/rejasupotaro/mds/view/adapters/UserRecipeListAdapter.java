package rejasupotaro.mds.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import rejasupotaro.mds.R;
import rejasupotaro.mds.data.models.Recipe;

import java.util.List;

public class UserRecipeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Recipe> recipes;

    public UserRecipeListAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).bind(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.user_image)
        ImageView userImageView;
        @Bind(R.id.user_name_text)
        TextView userNameTextView;
        @Bind(R.id.recipe_image)
        ImageView recipeImageView;
        @Bind(R.id.recipe_title_text)
        TextView recipeTitleTextView;
        @Bind(R.id.recipe_description_text)
        TextView recipeDescriptionTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public static ItemViewHolder create(ViewGroup parent) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user_recipe, parent, false);
            return new ItemViewHolder(itemView);
        }

        public void bind(Recipe recipe) {
            userImageView.setImageDrawable(userImageView.getResources().getDrawable(R.drawable.user));
            userNameTextView.setText(recipe.user().name());
            Picasso.with(recipeImageView.getContext())
                    .load(recipe.imageUrl())
                    .into(recipeImageView);
            recipeTitleTextView.setText(recipe.title());
            recipeDescriptionTextView.setText(recipe.description());
        }
    }
}

