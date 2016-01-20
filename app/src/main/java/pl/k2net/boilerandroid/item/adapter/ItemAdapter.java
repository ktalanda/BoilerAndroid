package pl.k2net.boilerandroid.item.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.item.viewholder.ItemViewHolder;
import pl.k2net.boilerandroid.domain.model.ItemModel;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<ItemModel> data;

    @Inject
    public ItemAdapter() {
        data = new ArrayList<>();
    }

    public void setData(List<ItemModel> itemModels) {
        data.clear();
        data.addAll(itemModels);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
