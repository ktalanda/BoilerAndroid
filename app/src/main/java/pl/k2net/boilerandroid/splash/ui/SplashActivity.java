package pl.k2net.boilerandroid.splash.ui;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.BaseActivity;
import pl.k2net.boilerandroid.di.qualifiers.LoginIntent;
import pl.k2net.boilerandroid.di.qualifiers.MainIntent;
import pl.k2net.boilerandroid.presentation.presenter.SplashPresenter;

public class SplashActivity extends BaseActivity implements SplashPresenter.ViewInterface {

    @Inject
    SplashPresenter presenter;
    @Inject @MainIntent
    Intent mainIntent;
    @Inject @LoginIntent
    Intent loginIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initActivityComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter.authenticate(this);
    }

    @Override
    public void authenticateAction(boolean success) {
        finish();
        startActivity(success
                ? mainIntent : loginIntent);
    }
}
