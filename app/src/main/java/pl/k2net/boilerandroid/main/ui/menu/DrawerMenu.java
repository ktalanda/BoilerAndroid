package pl.k2net.boilerandroid.main.ui.menu;

import android.support.annotation.StringRes;

import pl.k2net.boilerandroid.R;

public enum DrawerMenu implements MenuItemView {

    DASHBOARD(R.string.drawer_menu_dashboard, R.string.drawer_menu_dashboard_icon),
    SETTINGS(R.string.drawer_menu_settings, R.string.drawer_menu_settings_icon);

    @StringRes
    int labelRes;

    @StringRes
    int iconRes;

    DrawerMenu(int labelRes, int iconRes) {
        this.labelRes = labelRes;
        this.iconRes = iconRes;
    }

    @Override
    public int icon() {
        return iconRes;
    }

    @Override
    public int label() {
        return labelRes;
    }
}
