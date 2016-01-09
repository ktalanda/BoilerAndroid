package pl.k2net.boilerandroid.di;

import android.content.Context;

import pl.k2net.boilerandroid.common.ui.AppContainer;
import retrofit.Retrofit;

public interface ApplicationProvider {
    AppContainer provideAppContainer();
    Retrofit provideRetrofit();
    Context provideContext();
}
