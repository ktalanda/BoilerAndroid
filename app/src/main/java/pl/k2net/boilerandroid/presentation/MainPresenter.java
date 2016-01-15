package pl.k2net.boilerandroid.presentation;

import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.ItemEntity;
import pl.k2net.boilerandroid.domain.usecase.GetItemListUseCase;
import pl.k2net.boilerandroid.domain.usecase.SignoutUseCase;
import timber.log.Timber;

public class MainPresenter {

    @Inject
    SignoutUseCase signoutUseCase;

    @Inject
    GetItemListUseCase getItemListUseCase;

    @Inject
    MainPresenter() {
    }

    public void signout(ViewInterface view) {
        signoutUseCase.execute()
                .subscribe(result -> view.signoutAction(result));
    }

    public void getItemList(ViewInterface view) {
        getItemListUseCase.execute().subscribe(
                listResponse -> view.listItem(listResponse.body()),
                throwable -> Timber.e(throwable.getMessage())
        );
    }

    public interface ViewInterface {
        void signoutAction(boolean success);
        void listItem(List<ItemEntity> itemEntities);
    }
}
