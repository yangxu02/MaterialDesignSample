package rejasupotaro.mds.data.services;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import rejasupotaro.mds.data.models.Pokemons;
import rx.Observable;

public class SuggestionService {

    public Observable<List<String>> get(String query) {
        if (TextUtils.isEmpty(query)) {
            return Observable.just(new ArrayList<>());
        }

        return Observable.just(Pokemons.allPokemonNames(query));
    }
}
