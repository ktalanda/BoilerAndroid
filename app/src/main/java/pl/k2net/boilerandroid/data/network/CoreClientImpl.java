package pl.k2net.boilerandroid.data.network;

import java.util.Map;

import javax.inject.Inject;

import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class CoreClientImpl implements CoreClient {

    @Inject
    Retrofit retrofit;

    @Inject
    CoreClientImpl() {
    }

    @Override
    public Observable<Response<String>> ping() {
        return retrofit.create(CoreClient.class)
                .ping()
                .doOnError(throwable -> Timber.e(throwable.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Response<Map<String, String>>> mirror(Map<String, String> body) {
        return retrofit.create(CoreClient.class)
                .mirror(body)
                .doOnError(throwable -> Timber.e(throwable.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
