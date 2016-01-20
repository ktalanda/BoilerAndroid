package pl.k2net.boilerandroid.common.ui;

import android.support.v4.app.Fragment;

import pl.k2net.boilerandroid.di.ActivityComponentProvider;
import pl.k2net.boilerandroid.di.FragmentInjector;

public class BaseFragment extends Fragment {

    protected FragmentInjector fragmentInjector() {
        return ((ActivityComponentProvider) getActivity()).initActivityComponent();
    }
}
