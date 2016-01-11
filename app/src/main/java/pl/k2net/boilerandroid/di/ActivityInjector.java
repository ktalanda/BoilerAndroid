package pl.k2net.boilerandroid.di;

import pl.k2net.boilerandroid.main.ui.LoginActivity;
import pl.k2net.boilerandroid.main.ui.MainActivity;

public interface ActivityInjector {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
}
