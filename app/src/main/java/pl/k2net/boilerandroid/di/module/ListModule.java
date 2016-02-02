package pl.k2net.boilerandroid.di.module;

import java.util.LinkedList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.main.ui.menu.view.DrawerItemView;

@Module
public class ListModule {

    @Provides
    List<DrawerItemView> provideDrawerList() {
        return new LinkedList<>();
    }
}
