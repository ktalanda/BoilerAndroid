package pl.k2net.boilerandroid.common.ui;

import android.view.ViewGroup;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.ButterKnife;

@Singleton
public class AppContainerImpl implements AppContainer {

    @Inject
    AppContainerImpl() {
    }

    @Override
    public ViewGroup bind(BaseActivity baseActivity) {
        return ButterKnife.findById(baseActivity, android.R.id.content);
    }
}
