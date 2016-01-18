package pl.k2net.boilerandroid.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.k2net.boilerandroid.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    @Inject
    public ItemAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_name) TextView itemName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
