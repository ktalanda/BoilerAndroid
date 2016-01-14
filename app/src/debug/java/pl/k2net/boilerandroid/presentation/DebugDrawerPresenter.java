package pl.k2net.boilerandroid.presentation;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.GetCommonStorageUseCase;

public class DebugDrawerPresenter {

    @Inject
    GetCommonStorageUseCase getCommonStorage;

    @Inject
    public DebugDrawerPresenter() {
    }

    public void setUpCommonStorage(ViewInterface view) {
        getCommonStorage.execute()
                .subscribe(map -> view.setCommonStorageInfo(map.toString()));
    }

    public interface ViewInterface {
        void setCommonStorageInfo(String info);
    }
}
