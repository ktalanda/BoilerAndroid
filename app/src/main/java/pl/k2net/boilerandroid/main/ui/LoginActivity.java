package pl.k2net.boilerandroid.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.BaseActivity;
import pl.k2net.boilerandroid.di.providers.SnackbarProvider;
import pl.k2net.boilerandroid.presentation.LoginPresenter;

public class LoginActivity extends BaseActivity implements LoginPresenter.ViewInterface {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.login_username)
    EditText username;
    @Bind(R.id.login_password)
    EditText password;
    @Bind(R.id.login_main_layout)
    CoordinatorLayout loginMainLayout;

    @Inject
    SnackbarProvider snackbarProvider;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent().inject(this);
        bindContentView(R.layout.activity_login, savedInstanceState);
        setSupportActionBar(toolbar);

    }

    @OnClick(R.id.login_submit)
    public void onSubmitAction(View view) {
        String usernameCredentials = username.getText().toString();
        presenter.login(usernameCredentials, "1qazse432", this);
    }

    @Override
    public void loginAction(boolean success) {
        if (success) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            snackbarProvider.get(loginMainLayout, "LOGIN FAILED", Snackbar.LENGTH_SHORT).show();
        }
    }
}
