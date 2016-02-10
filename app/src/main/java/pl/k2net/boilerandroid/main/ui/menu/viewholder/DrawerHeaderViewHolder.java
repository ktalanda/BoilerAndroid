package pl.k2net.boilerandroid.main.ui.menu.viewholder;

import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.di.qualifiers.DrawerHeaderViewQualifier;
import pl.k2net.boilerandroid.main.ui.menu.view.DrawerHeaderView;

public class DrawerHeaderViewHolder extends CommonMenuViewHolder<DrawerHeaderView> {

    @Bind(R.id.drawer_header_username)
    TextView username;

    @Inject
    public DrawerHeaderViewHolder(@DrawerHeaderViewQualifier View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(DrawerHeaderView value) {
        username.setText(value.username());
    }
}
