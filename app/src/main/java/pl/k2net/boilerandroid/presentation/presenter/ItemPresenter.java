package pl.k2net.boilerandroid.presentation.presenter;

import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.GetItemListUseCase;
import pl.k2net.boilerandroid.domain.model.ItemModel;
import timber.log.Timber;

public class ItemPresenter {

    @Inject
    GetItemListUseCase getItemListUseCase;

    private ViewInterface view;

    @Inject
    ItemPresenter() {
    }

    public void bind(ViewInterface view) {
        if (this.view != null) {
            throw new RuntimeException("Concurrent view bind! Unexpected, second instance of view occurred"
                    + " before first one unbind.");
        }
        this.view = view;
    }

    public void getItemList() {
        getItemListUseCase.execute()
                .subscribe(
                        view::showItemList,
                        throwable -> Timber.wtf("ERROR")
                );
    }

    public interface ViewInterface {
        void showItemList(List<ItemModel> itemModelList);
    }

}
