package pl.k2net.boilerandroid.main.ui.menu;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import lombok.Setter;
import pl.k2net.boilerandroid.main.ui.menu.view.DrawerHeaderView;
import pl.k2net.boilerandroid.main.ui.menu.view.DrawerItemView;
import pl.k2net.boilerandroid.main.ui.menu.viewholder.CommonMenuViewHolder;
import pl.k2net.boilerandroid.main.ui.menu.viewholder.DrawerHeaderViewHolder;
import pl.k2net.boilerandroid.main.ui.menu.viewholder.DrawerItemViewHolder;

public class DrawerMenuAdapter extends RecyclerView.Adapter<CommonMenuViewHolder<?>> {

    public static final int HEADER = 0;
    public static final int ITEM = 1;

    @Setter
    DrawerHeaderView headerView;

    @Inject
    Provider<DrawerItemViewHolder> drawerViewHolderProvider;

    @Inject
    Provider<DrawerHeaderViewHolder> headerViewHolderProvider;

    @Inject
    List<DrawerItemView> drawerItemViewList;

    @Inject
    DrawerMenuAdapter() {
    }

    @Override
    public CommonMenuViewHolder<?> onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                return createHeaderViewHolder();
            case ITEM:
                return createItemViewHolder();
            default:
                throw new IllegalArgumentException("Type " + viewType + " is not supported");
        }
    }

    @Override
    public void onBindViewHolder(CommonMenuViewHolder<?> holder, int position) {
        if (HEADER == getItemViewType(position)) {
            DrawerHeaderViewHolder headerViewHolder = (DrawerHeaderViewHolder) holder;
            headerViewHolder.bind(headerView);
        } else {
            DrawerItemViewHolder itemViewHolder = (DrawerItemViewHolder) holder;
            itemViewHolder.bind(drawerItemViewList.get(position - (isHeader() ? 1 : 0)));
        }
    }

    @Override
    public int getItemCount() {
        return drawerItemViewList.size() + (isHeader() ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader() && position == 0) {
            return HEADER;
        }
        return ITEM;
    }

    public void addItem(DrawerItemView itemView) {
        drawerItemViewList.add(itemView);
    }

    private boolean isHeader() {
        return headerView != null;
    }

    private DrawerItemViewHolder createItemViewHolder() {
        return drawerViewHolderProvider.get();
    }

    private DrawerHeaderViewHolder createHeaderViewHolder() {
        return headerViewHolderProvider.get();
    }
}
