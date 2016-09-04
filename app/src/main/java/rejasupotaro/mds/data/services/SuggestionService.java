package rejasupotaro.mds.data.services;

import rejasupotaro.mds.data.models.Pokemons;
import rejasupotaro.mds.di.components.ApplicationComponent;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

public class SuggestionService extends BaseService {

    public SuggestionService(ApplicationComponent applicationComponent) {
        super(applicationComponent);
    }

    public Observable<List<String>> get(String query) {

        return makeObservable(Pokemons.allPokemonNames(applicationComponent.context(), query)).subscribeOn(Schedulers.computation());

    }
}
