package pl.k2net.boilerandroid.di;

import android.content.Context;
import android.content.Intent;

import java.util.List;

import pl.k2net.boilerandroid.common.ui.AppContainer;
import pl.k2net.boilerandroid.di.qualifiers.LoginIntent;
import pl.k2net.boilerandroid.di.qualifiers.MainIntent;
import pl.k2net.boilerandroid.main.ui.menu.MenuItemView;
import retrofit.Retrofit;

public interface ApplicationProvider {
    AppContainer provideAppContainer();
    Retrofit provideRetrofit();
    Context provideContext();
    @LoginIntent Intent provideLoginIntent();
    @MainIntent Intent provideMainIntent();
    List<MenuItemView> provideDrawerList();
}
