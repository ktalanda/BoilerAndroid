package pl.k2net.boilerandroid.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {
    Context context;

    public StorageModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
