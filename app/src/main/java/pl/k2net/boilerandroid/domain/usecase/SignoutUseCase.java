package pl.k2net.boilerandroid.domain.usecase;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.storage.CommonStorage;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SignoutUseCase {

    @Inject
    CommonStorage storage;

    @Inject
    SignoutUseCase() {
    }

    public Observable<Boolean> execute() {
        return storage.clearAuthCookies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
