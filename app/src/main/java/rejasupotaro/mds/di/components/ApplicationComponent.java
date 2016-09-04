package rejasupotaro.mds.di.components;

import android.content.Context;
import dagger.Component;
import rejasupotaro.mds.di.modules.ApplicationModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
}
