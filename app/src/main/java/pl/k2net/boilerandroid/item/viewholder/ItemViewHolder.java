package pl.k2net.boilerandroid.item.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.domain.model.ItemModel;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.item_name)
    TextView itemName;

    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ItemModel itemModel) {
        itemName.setText(itemModel.getName());
    }
}
