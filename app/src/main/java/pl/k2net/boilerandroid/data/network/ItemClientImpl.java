package pl.k2net.boilerandroid.data.network;

import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.ItemEntity;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class ItemClientImpl implements ItemClient {

    private Retrofit retrofit;

    @Inject
    public ItemClientImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Observable<Response<List<ItemEntity>>> list() {
        return retrofit.create(ItemClient.class)
                .list()
                .doOnError(throwable -> Timber.e(throwable.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
