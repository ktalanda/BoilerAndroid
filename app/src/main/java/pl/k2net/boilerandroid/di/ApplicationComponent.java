package pl.k2net.boilerandroid.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pl.k2net.boilerandroid.MyApplication;
import pl.k2net.boilerandroid.di.module.IntentModule;
import pl.k2net.boilerandroid.di.module.ListModule;
import pl.k2net.boilerandroid.di.module.NetworkModule;
import pl.k2net.boilerandroid.di.module.StorageModule;
import pl.k2net.boilerandroid.di.module.UIModule;

@Singleton
@Component(modules = { UIModule.class, NetworkModule.class, StorageModule.class, IntentModule.class, ListModule.class})
public interface ApplicationComponent extends ApplicationProvider {

    void inject(MyApplication app);

    final class Initializer {
        private Initializer() { }
        public static ApplicationComponent init(Context context) {
            return DaggerApplicationComponent
                    .builder()
                    .uIModule(new UIModule(context))
                    .networkModule(new NetworkModule())
                    .storageModule(new StorageModule(context))
                    .intentModule(new IntentModule(context))
                    .listModule(new ListModule())
                    .build();
        }
    }
}
