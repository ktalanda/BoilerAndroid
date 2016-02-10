package pl.k2net.boilerandroid.di.module;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.BaseActivity;
import pl.k2net.boilerandroid.di.qualifiers.DrawerHeaderViewQualifier;
import pl.k2net.boilerandroid.di.qualifiers.DrawerItemViewQualifier;

@Module
public class ViewModule {
    BaseActivity baseActivity;

    public ViewModule(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    RecyclerView.LayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(baseActivity);
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(baseActivity);
    }

    @DrawerItemViewQualifier
    @Provides
    View provideDrawerItemView(LayoutInflater layoutInflater) {
        return layoutInflater
                .inflate(
                        R.layout.view_drawer_item,
                        (ViewGroup) baseActivity.findViewById(R.id.main_menu_frame),
                        false);
    }

    @DrawerHeaderViewQualifier
    @Provides
    View provideDrawerHeaderView(LayoutInflater layoutInflater) {
        return layoutInflater
                .inflate(
                        R.layout.view_drawer_header,
                        (ViewGroup) baseActivity.findViewById(R.id.main_menu_frame),
                        false);
    }
}
