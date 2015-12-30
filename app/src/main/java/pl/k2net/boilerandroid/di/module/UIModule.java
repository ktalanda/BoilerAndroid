package pl.k2net.boilerandroid.di.module;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.common.ui.AppContainer;
import pl.k2net.boilerandroid.common.ui.AppContainerImpl;

@Module
public class UIModule {

    public UIModule() {
    }

    @Provides
    AppContainer provideAppContainerImpl(AppContainerImpl appContainer) {
        return appContainer;
    }
}
