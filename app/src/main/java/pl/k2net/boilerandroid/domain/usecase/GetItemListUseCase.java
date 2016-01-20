package pl.k2net.boilerandroid.domain.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.ItemEntity;
import pl.k2net.boilerandroid.data.network.ItemClientImpl;
import pl.k2net.boilerandroid.domain.model.ItemModel;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetItemListUseCase {

    @Inject
    ItemClientImpl itemClient;

    @Inject
    public GetItemListUseCase() {
    }

    public Observable<List<ItemModel>> execute() {
        return itemClient.list()
                .map(listResponse -> convertList(listResponse.body()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private List<ItemModel> convertList(List<ItemEntity> entities) {
        List<ItemModel> response = new ArrayList<>();
        for (ItemEntity entity: entities) {
            response.add(new ItemModel(entity));
        }
        return response;
    }
}