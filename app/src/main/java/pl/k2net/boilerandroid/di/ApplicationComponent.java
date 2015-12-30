package pl.k2net.boilerandroid.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.k2net.boilerandroid.MyApplication;
import pl.k2net.boilerandroid.di.module.UIModule;

@Singleton
@Component(modules = { UIModule.class })
public interface ApplicationComponent extends ApplicationProvider {

    void inject(MyApplication app);

    final class Initializer {
        private Initializer() { }
        public static ApplicationComponent init() {
            return DaggerApplicationComponent
                    .builder()
                    .uIModule(new UIModule())
                    .build();
        }
    }
}
