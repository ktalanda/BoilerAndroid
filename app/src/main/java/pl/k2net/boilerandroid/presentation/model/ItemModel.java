package pl.k2net.boilerandroid.presentation.model;

import lombok.Data;
import pl.k2net.boilerandroid.data.entity.ItemEntity;

@Data
public class ItemModel {

    public ItemModel(ItemEntity entity) {
        this.name = entity.getName();
    }

    String name;
}
