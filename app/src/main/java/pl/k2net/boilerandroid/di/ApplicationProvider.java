package pl.k2net.boilerandroid.di;

import android.content.Context;
import android.content.Intent;

import pl.k2net.boilerandroid.common.ui.AppContainer;
import pl.k2net.boilerandroid.di.qualifiers.LoginIntent;
import pl.k2net.boilerandroid.di.qualifiers.MainIntent;
import retrofit.Retrofit;

public interface ApplicationProvider {
    AppContainer provideAppContainer();
    Retrofit provideRetrofit();
    Context provideContext();
    @LoginIntent
    Intent provideLoginIntent();
    @MainIntent
    Intent provideMainIntent();
}
