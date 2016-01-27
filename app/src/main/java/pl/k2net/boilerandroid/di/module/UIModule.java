package pl.k2net.boilerandroid.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.common.ui.AppContainer;
import pl.k2net.boilerandroid.common.ui.AppContainerImpl;

@Module
public class UIModule {

    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    AppContainer provideAppContainerImpl(AppContainerImpl appContainer) {
        return appContainer;
    }

}
