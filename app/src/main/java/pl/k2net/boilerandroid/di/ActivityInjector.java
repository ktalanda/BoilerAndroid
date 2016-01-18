package pl.k2net.boilerandroid.di;

import pl.k2net.boilerandroid.login.ui.LoginActivity;
import pl.k2net.boilerandroid.main.ui.MainActivity;
import pl.k2net.boilerandroid.splash.ui.SplashActivity;

public interface ActivityInjector {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(SplashActivity splashActivity);
}
