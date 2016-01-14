package pl.k2net.boilerandroid;

import android.app.Application;
import android.content.Context;

import pl.k2net.boilerandroid.di.ApplicationComponent;
import timber.log.Timber;

public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = ApplicationComponent.Initializer.init(this);
        applicationComponent.inject(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static ApplicationComponent component(Context context) {
        return ((MyApplication) context
                .getApplicationContext())
                .applicationComponent;
    }
}
