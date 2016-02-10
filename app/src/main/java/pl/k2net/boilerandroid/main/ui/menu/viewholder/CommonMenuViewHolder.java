package pl.k2net.boilerandroid.main.ui.menu.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class CommonMenuViewHolder<V> extends RecyclerView.ViewHolder {
    public CommonMenuViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(V value);
}
