package pl.k2net.boilerandroid.main.ui.menu;

import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.CommonViewHolder;
import pl.k2net.boilerandroid.di.qualifiers.DrawerItemView;

public class DrawerViewHolder extends CommonViewHolder<MenuItemView>{

    @Bind(R.id.drawer_item_label)
    TextView label;

    @Inject
    public DrawerViewHolder(@DrawerItemView View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(MenuItemView menuItemView) {
        label.setText(menuItemView.label());
    }
}
