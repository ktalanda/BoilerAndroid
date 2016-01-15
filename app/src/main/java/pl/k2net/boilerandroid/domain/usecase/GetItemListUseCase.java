package pl.k2net.boilerandroid.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.ItemEntity;
import pl.k2net.boilerandroid.data.network.ItemClientImpl;
import retrofit.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetItemListUseCase {

    @Inject
    ItemClientImpl itemClient;

    @Inject
    public GetItemListUseCase() {
    }

    public Observable<Response<List<ItemEntity>>> execute() {
        return itemClient.list()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}
