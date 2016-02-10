package pl.k2net.boilerandroid.main.ui.menu.view;

import android.support.annotation.StringRes;

public interface DrawerItemView {

    @StringRes
    int icon();

    @StringRes
    int label();
}
