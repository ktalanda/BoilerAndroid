package pl.k2net.boilerandroid.domain.usecase;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.UserEntity;
import pl.k2net.boilerandroid.data.network.AuthClientImpl;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AuthenticateUseCase {

    @Inject
    AuthClientImpl authClient;

    @Inject
    AuthenticateUseCase() {
    }

    public Observable<UserEntity> execute() {
        return authClient.me()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
