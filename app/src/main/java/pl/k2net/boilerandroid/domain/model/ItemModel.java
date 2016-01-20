package pl.k2net.boilerandroid.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.k2net.boilerandroid.data.entity.ItemEntity;

@Data
@AllArgsConstructor
public class ItemModel {
    String name;

    String name;

    public ItemModel(ItemEntity entity) {
        this.name = entity.getName();
    }

}
