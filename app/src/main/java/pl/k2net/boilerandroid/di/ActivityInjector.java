package pl.k2net.boilerandroid.di;

import pl.k2net.boilerandroid.main.ui.LoginActivity;
import pl.k2net.boilerandroid.main.ui.MainActivity;
import pl.k2net.boilerandroid.main.ui.SplashActivity;

public interface ActivityInjector {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(SplashActivity splashActivity);
}
