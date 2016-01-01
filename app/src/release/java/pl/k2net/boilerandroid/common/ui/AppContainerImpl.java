package pl.k2net.boilerandroid.common.ui;

import android.os.Bundle;
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
    public ViewGroup bind(BaseActivity baseActivity,
                          Bundle savedInstanceState) {
        return ButterKnife.findById(baseActivity, android.R.id.content);
    }

    @Override
    public Bundle saveInstanceState(Bundle savedInstanceState) {
        return savedInstanceState;
    }
}
