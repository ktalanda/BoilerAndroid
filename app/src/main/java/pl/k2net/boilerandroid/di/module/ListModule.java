package pl.k2net.boilerandroid.di.module;

import java.util.LinkedList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.main.ui.menu.MenuItemView;

@Module
public class ListModule {

    @Provides
    List<MenuItemView> provideDrawerList() {
        return new LinkedList<>();
    }
}
