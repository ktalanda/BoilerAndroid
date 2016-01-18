package pl.k2net.boilerandroid.presentation.presenter;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.entity.ItemEntity;
import pl.k2net.boilerandroid.domain.usecase.GetItemListUseCase;
import pl.k2net.boilerandroid.domain.usecase.SignoutUseCase;
import pl.k2net.boilerandroid.presentation.model.ItemModel;
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
                listResponse -> view.listItem(mapItemEntityList(listResponse.body())),
                throwable -> Timber.e(throwable.getMessage())
        );
    }

    private List<ItemModel> mapItemEntityList(List<ItemEntity> itemEntities) {
        List<ItemModel> result = new ArrayList<>();
        for (ItemEntity entity : itemEntities) {
            result.add(new ItemModel(entity));
        }
        return result;
    }

    public interface ViewInterface {
        void signoutAction(boolean success);

        void listItem(List<ItemModel> items);
    }
}
