package pl.k2net.boilerandroid.presentation;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.SignoutUseCase;

public class MainPresenter {

    @Inject
    SignoutUseCase signoutUseCase;

    @Inject
    MainPresenter() {
    }

    public void signout(ViewInterface view) {
        signoutUseCase.execute()
                .subscribe(result -> view.signoutAction(result));
    }

    public interface ViewInterface {
        void signoutAction(boolean success);
    }
}
