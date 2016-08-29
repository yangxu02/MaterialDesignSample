package rejasupotaro.mds.data.models;

/**
 * Created by ulyx.yang@yeahmobi.com on 2016/8/29.
 */
public class MaterialSource {

    public static class PokemonWrapper {

        private final static String imgRepo
            = "https://img.pokemondb.net/artwork/";
        private final static String iconRepo
            = "https://img.pokemondb.net/sprites/black-white/normal/";

        public static String imageUrl(Pokemon pokemon) {
            return imgRepo + pokemon.name().toLowerCase() + ".jpg";
        }

        public static String iconUrl(Pokemon pokemon) {
            return iconRepo + pokemon.name().toLowerCase() + ".png";
        }
    }

}
