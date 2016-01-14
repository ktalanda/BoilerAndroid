package pl.k2net.boilerandroid.domain.usecase;

import java.util.Map;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.storage.CommonStorage;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetCommonStorageUseCase {

    @Inject
    CommonStorage storage;

    @Inject
    public GetCommonStorageUseCase() {
    }

    public Observable<Map<String, ?>> execute() {
        return storage.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
