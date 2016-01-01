package pl.k2net.boilerandroid.common.ui;

import android.os.Bundle;
import android.view.ViewGroup;

public interface AppContainer {
    ViewGroup bind(BaseActivity baseActivity, Bundle savedInstanceState);
    Bundle saveInstanceState(Bundle savedInstanceState);
}
