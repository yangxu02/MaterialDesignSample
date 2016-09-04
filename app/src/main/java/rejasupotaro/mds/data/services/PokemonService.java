package rejasupotaro.mds.data.services;

import rejasupotaro.mds.data.models.PokemonDetail;
import rejasupotaro.mds.data.models.PokemonSnippet;
import rejasupotaro.mds.data.models.Pokemons;
import rejasupotaro.mds.di.components.ApplicationComponent;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

public class PokemonService extends BaseService {

    public PokemonService(ApplicationComponent applicationComponent) {
        super(applicationComponent);
    }

    public Observable<List<PokemonSnippet>> getSnippets() {
        return makeObservable(Pokemons.allPokemons(applicationComponent.context())).subscribeOn(Schedulers.computation());
    }

    public Observable<PokemonDetail> getDetail(String name) {
        return makeObservable(Pokemons.pokemonDetail(applicationComponent.context(), name)).subscribeOn(Schedulers.computation());
    }

    public Observable<PokemonDetail> getDetail(PokemonSnippet snippet) {
        return makeObservable(Pokemons.pokemonDetail(applicationComponent.context(), snippet)).subscribeOn(Schedulers.computation());
    }


}
