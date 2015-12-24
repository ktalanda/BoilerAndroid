package pl.k2net.boilerandroid.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {})
public interface ApplicationComponent {
    class Initializer {
        public static ApplicationComponent init(Context context){
            return DaggerApplicationComponent
                    .builder()
                    .build();
        }
    }
}
