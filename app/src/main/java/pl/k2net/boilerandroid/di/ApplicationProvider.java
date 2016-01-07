package pl.k2net.boilerandroid.di;

import pl.k2net.boilerandroid.common.ui.AppContainer;
import retrofit.Retrofit;

public interface ApplicationProvider {
    AppContainer provideAppContainer();
    Retrofit provideRetrofit();
}
