package pl.k2net.boilerandroid.main.ui.menu;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import pl.k2net.boilerandroid.common.ui.CommonViewHolder;

public class DrawerMenuAdapter extends RecyclerView.Adapter<CommonViewHolder<?>> {

    @Inject
    Provider<DrawerViewHolder> drawerViewHolderProvider;

    @Inject
    List<MenuItemView> drawerItemViewList;

    @Inject
    DrawerMenuAdapter() {
    }

    @Override
    public CommonViewHolder<?> onCreateViewHolder(ViewGroup parent, int viewType) {
        return drawerViewHolderProvider.get();
    }

    @Override
    public void onBindViewHolder(CommonViewHolder<?> holder, int position) {
        ((DrawerViewHolder) holder).bind(drawerItemViewList.get(position));
    }

    @Override
    public int getItemCount() {
        return drawerItemViewList.size();
    }

    public void addItem(MenuItemView itemView) {
        drawerItemViewList.add(itemView);
    }
}
