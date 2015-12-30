package pl.k2net.boilerandroid.common.ui;

import android.view.ViewGroup;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import pl.k2net.boilerandroid.R;

@Singleton
public class AppContainerImpl implements AppContainer {

    @Inject
    Provider<ActivityViewHolder> holderProvider;

    @Inject
    AppContainerImpl() {
    }

    @Override
    public ViewGroup bind(BaseActivity baseActivity) {
        baseActivity.setContentView(R.layout.debug_activity_frame);
        return holderProvider.get().withBoundViews(baseActivity).content;
    }
}
