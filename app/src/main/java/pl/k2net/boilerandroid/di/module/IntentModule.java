package pl.k2net.boilerandroid.di.module;

import android.content.Context;
import android.content.Intent;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.di.qualifiers.LoginIntent;
import pl.k2net.boilerandroid.di.qualifiers.MainIntent;
import pl.k2net.boilerandroid.main.ui.LoginActivity;
import pl.k2net.boilerandroid.main.ui.MainActivity;

@Module
public class IntentModule {
    private Context context;

    public IntentModule(Context context) {
        this.context = context;
    }

    @MainIntent
    @Provides
    Intent provideMainIntent() {
        return new Intent(context, MainActivity.class);
    }

    @LoginIntent
    @Provides
    Intent provideLoginIntent() {
        return new Intent(context, LoginActivity.class);
    }


}
