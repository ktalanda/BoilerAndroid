package pl.k2net.boilerandroid.presentation.presenter;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.SignoutUseCase;

public class MainPresenter extends BasePresenter<MainPresenter.ViewInterface> {

    @Inject
    SignoutUseCase signoutUseCase;

    @Inject
    MainPresenter() {
    }

    public void signout() {
        signoutUseCase.execute()
                .subscribe(getView()::signoutAction);
    }

    public interface ViewInterface {
        void signoutAction(boolean success);

    }

}
