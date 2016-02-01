package pl.k2net.boilerandroid.main.ui.menu;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.CommonViewHolder;
import pl.k2net.boilerandroid.di.qualifiers.DrawerItemView;

public class DrawerViewHolder extends CommonViewHolder<MenuItemView> {

    @Bind(R.id.drawer_item_label)
    TextView label;

    @Bind(R.id.drawer_item_icon)
    TextView icon;

//    @BindString(R.string.font_awesome)
//    String fontAwesome;

    @Inject
    public DrawerViewHolder(@DrawerItemView View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(MenuItemView menuItemView) {
        icon.setTypeface(Typeface.createFromAsset(icon.getContext().getAssets(), "fontawesome-webfont.ttf"));
        icon.setText(menuItemView.icon());
        label.setText(menuItemView.label());
    }
}
