package pl.k2net.boilerandroid.presentation.presenter;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.SigninUseCase;

public class LoginPresenter {
    @Inject
    SigninUseCase signinUseCase;

    @Inject
    LoginPresenter() {
    }

    public void login(String username, String password, ViewInterface view) {
        signinUseCase.execute(username, password)
                .subscribe(
                        userEntity -> view.loginAction(),
                        throwable -> view.loginFailed(throwable.getMessage())
                );
    }

    public interface ViewInterface {
        void loginAction();
        void loginFailed(String error);
    }

}
