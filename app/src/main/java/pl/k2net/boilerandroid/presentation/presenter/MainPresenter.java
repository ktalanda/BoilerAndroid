package pl.k2net.boilerandroid.presentation.presenter;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.GetItemListUseCase;
import pl.k2net.boilerandroid.domain.usecase.SignoutUseCase;

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
                .subscribe(view::signoutAction);
    }

    public interface ViewInterface {
        void signoutAction(boolean success);

    }

}
