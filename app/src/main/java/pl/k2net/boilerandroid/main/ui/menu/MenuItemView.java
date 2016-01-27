package pl.k2net.boilerandroid.main.ui.menu;

import android.support.annotation.StringRes;

public interface MenuItemView {

    @StringRes
    int icon();
    @StringRes
    int label();
}
