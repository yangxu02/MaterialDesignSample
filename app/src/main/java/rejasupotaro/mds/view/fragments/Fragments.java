package rejasupotaro.mds.view.fragments;

import android.support.v4.app.Fragment;
import android.util.Log;
import rejasupotaro.mds.data.models.PokemonDetail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Fragments {
    public static Fragment create(Class<? extends Fragment> clazz, PokemonDetail pokemonDetail) {
        if (null == clazz) return null;
        try {
            Method method = clazz.getDeclaredMethod("newInstance", PokemonDetail.class);
            return (Fragment) method.invoke(null, pokemonDetail);
        } catch (IllegalAccessException e) {
            Log.e("", "instantiate fragment " + clazz.getName() + " failed", e);
        } catch (NoSuchMethodException e) {
            Log.e("", "instantiate fragment " + clazz.getName() + " failed", e);
        } catch (InvocationTargetException e) {
            Log.e("", "instantiate fragment " + clazz.getName() + " failed", e);
        }
        return null;
    }

}
