package pl.k2net.boilerandroid.main.ui.menu.viewholder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.di.qualifiers.DrawerItemViewQualifier;
import pl.k2net.boilerandroid.main.ui.menu.view.DrawerItemView;

public class DrawerItemViewHolder extends CommonMenuViewHolder<DrawerItemView> {

    @Bind(R.id.drawer_item_label)
    TextView label;

    @Bind(R.id.drawer_item_icon)
    TextView icon;
//
//    @BindString(R.string.font_awesome)
//    String fontAwesome;

    @Inject
    public DrawerItemViewHolder(@DrawerItemViewQualifier View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(DrawerItemView drawerItemView) {
        icon.setTypeface(Typeface.createFromAsset(icon.getContext().getAssets(), "fontawesome-webfont.ttf"));
        icon.setText(drawerItemView.icon());
        label.setText(drawerItemView.label());
    }
}
