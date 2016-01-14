package pl.k2net.boilerandroid.data.network;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.UserEntity;
import pl.k2net.boilerandroid.data.network.dto.AuthDTO;
import retrofit.Retrofit;
import retrofit.http.Body;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class AuthClientImpl implements AuthClient {

    @Inject
    Retrofit retrofit;

    @Inject
    public AuthClientImpl() {
    }

    @Override
    public Observable<UserEntity> signin(@Body AuthDTO authData) {
        return retrofit.create(AuthClient.class)
                .signin(authData)
                .doOnError(throwable -> Timber.e(throwable.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<UserEntity> me() {
        return retrofit.create(AuthClient.class)
                .me()
                .doOnError(throwable -> Timber.e(throwable.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
