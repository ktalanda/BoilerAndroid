package pl.k2net.boilerandroid.presentation.presenter;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.AuthenticateUseCase;

public class SplashPresenter extends BasePresenter<SplashPresenter.ViewInterface> {
    @Inject
    AuthenticateUseCase authenticateUseCase;

    @Inject
    SplashPresenter() {
    }

    public void authenticate() {
        authenticateUseCase.execute()
                .subscribe(
                        userEntity -> getView().authenticateAction(userEntity != null),
                        throwable -> getView().authenticateAction(false));
    }

    public interface ViewInterface {
        void authenticateAction(boolean success);
    }

}
