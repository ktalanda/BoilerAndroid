package pl.k2net.boilerandroid.main.ui;

import android.os.Bundle;
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

public class LoginActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.login_username)
    EditText username;
    @Bind(R.id.login_password)
    EditText password;

    @Inject
    SnackbarProvider snackbarProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityComponent().inject(this);
        bindContentView(R.layout.activity_login, savedInstanceState);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.login_submit)
    public void onSubmitAction(View view) {
        snackbarProvider.get(view, "CLICKED", Snackbar.LENGTH_SHORT).show();
    }

}
