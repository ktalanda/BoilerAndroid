package pl.k2net.boilerandroid.presentation.presenter;

import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.GetItemListUseCase;
import pl.k2net.boilerandroid.domain.model.ItemModel;
import timber.log.Timber;

public class ItemPresenter extends BasePresenter<ItemPresenter.ViewInterface> {

    @Inject
    GetItemListUseCase getItemListUseCase;

    @Inject
    ItemPresenter() {
    }

    public void getItemList() {
        getItemListUseCase.execute()
                .subscribe(
                        getView()::showItemList,
                        throwable -> Timber.wtf("ERROR")
                );
    }

    public interface ViewInterface {
        void showItemList(List<ItemModel> itemModelList);
    }

}
