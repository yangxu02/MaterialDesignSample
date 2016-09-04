package rejasupotaro.mds.di.modules;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import rejasupotaro.mds.AndroidApplication;

import javax.inject.Singleton;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }
}
