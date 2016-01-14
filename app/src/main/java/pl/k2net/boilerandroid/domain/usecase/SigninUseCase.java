package pl.k2net.boilerandroid.domain.usecase;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.UserEntity;
import pl.k2net.boilerandroid.data.network.AuthClientImpl;
import pl.k2net.boilerandroid.data.network.dto.AuthDTO;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SigninUseCase {

    @Inject
    AuthClientImpl authClient;

    @Inject
    SigninUseCase() {
    }

    public Observable<UserEntity> execute(String username, String password) {
        return authClient.signin(new AuthDTO(username, password))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
