package pl.k2net.boilerandroid.main.ui.menu;

import android.support.annotation.StringRes;

import pl.k2net.boilerandroid.R;

public enum DrawerMenu implements MenuItemView {

    TEST(R.string.app_name, 0),
    TEST_1(R.string.app_name, 0);

    DrawerMenu(int labelRes, int iconRes) {
        this.labelRes = labelRes;
    }

    @StringRes
    int labelRes;

    @Override
    public int icon() {
        return 0;
    }

    @Override
    public int label() {
        return labelRes;
    }
}
