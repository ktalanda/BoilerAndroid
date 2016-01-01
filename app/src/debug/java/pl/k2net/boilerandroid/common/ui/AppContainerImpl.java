package pl.k2net.boilerandroid.common.ui;

import android.os.Bundle;
import android.view.ViewGroup;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import pl.k2net.boilerandroid.R;

@Singleton
public class AppContainerImpl implements AppContainer {

    public static final String BUNDLE_DRAWER_OPEN = "drawer_open";

    @Inject
    Provider<ActivityViewHolder> holderProvider;

    private ActivityViewHolder drawerContent;

    @Inject
    AppContainerImpl() {
    }

    @Override
    public ViewGroup bind(BaseActivity baseActivity,
                          Bundle savedInstanceState) {
        baseActivity.setContentView(R.layout.debug_activity_frame);
        drawerContent = holderProvider.get().withBoundViews(baseActivity,
                savedInstanceState);
        return drawerContent.content;
    }

    @Override
    public Bundle saveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(BUNDLE_DRAWER_OPEN,
                drawerContent.isDrawerOpen());
        return savedInstanceState;
    }
}
