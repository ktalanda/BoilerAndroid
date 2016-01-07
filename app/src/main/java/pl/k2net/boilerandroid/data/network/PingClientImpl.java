package pl.k2net.boilerandroid.data.network;

import javax.inject.Inject;

import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PingClientImpl implements PingClient {

    @Inject
    Retrofit retrofit;

    @Inject
    PingClientImpl() {
    }

    @Override
    public Observable<Response<String>> ping() {
        return retrofit.create(PingClient.class)
                .ping()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
