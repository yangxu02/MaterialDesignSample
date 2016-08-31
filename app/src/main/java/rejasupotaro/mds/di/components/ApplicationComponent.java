package rejasupotaro.mds.di.components;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import rejasupotaro.mds.di.modules.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
}
