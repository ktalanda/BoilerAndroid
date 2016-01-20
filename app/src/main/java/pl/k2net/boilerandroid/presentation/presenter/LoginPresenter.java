package pl.k2net.boilerandroid.presentation.presenter;

import javax.inject.Inject;

import pl.k2net.boilerandroid.domain.usecase.SigninUseCase;

public class LoginPresenter extends BasePresenter<LoginPresenter.ViewInterface> {
    @Inject
    SigninUseCase signinUseCase;

    @Inject
    LoginPresenter() {
    }

    public void login(String username, String password) {
        signinUseCase.execute(username, password)
                .subscribe(
                        userEntity -> getView().loginAction(),
                        throwable -> getView().loginFailed(throwable.getMessage())
                );
    }

    public interface ViewInterface {
        void loginAction();
        void loginFailed(String error);
    }

}
