package pl.k2net.boilerandroid.presentation;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.AuthenticateUseCase;

public class SplashPresenter {
    @Inject
    AuthenticateUseCase authenticateUseCase;

    @Inject
    SplashPresenter() {
    }

    public void authenticate(ViewInterface view) {
        authenticateUseCase.execute()
                .subscribe(
                        userEntity -> {
                            if (userEntity == null) {
                                view.authenticateAction(false);
                            } else {
                                view.authenticateAction(true);
                            }
                        },
                        throwable -> view.authenticateAction(false)
                );
    }

    public interface ViewInterface {
        void authenticateAction(boolean success);
    }

}
