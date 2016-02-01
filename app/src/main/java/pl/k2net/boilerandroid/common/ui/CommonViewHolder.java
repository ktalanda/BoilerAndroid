package pl.k2net.boilerandroid.common.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class CommonViewHolder<V> extends RecyclerView.ViewHolder {
    public CommonViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(V value);
}
