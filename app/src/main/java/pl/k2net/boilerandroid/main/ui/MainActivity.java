package pl.k2net.boilerandroid.main.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.BaseActivity;
import pl.k2net.boilerandroid.di.providers.SnackbarProvider;
import pl.k2net.boilerandroid.presentation.MainPresenter;

public class MainActivity extends BaseActivity implements MainPresenter.ViewInterface {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer)
    DrawerLayout drawer;

    @Inject
    SnackbarProvider snackbarProvider;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initActivityComponent().inject(this);
        super.onCreate(savedInstanceState);
        bindContentView(R.layout.activity_main, savedInstanceState);
        setUpToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        }
    }

    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        snackbarProvider
                .get(view, "test", Snackbar.LENGTH_SHORT)
                .setAction("Action", null)
                .show();
    }

    @OnClick(R.id.logout)
    public void onLogoutClick(View view) {
        presenter.signout(this);
    }

    @Override
    public void signoutAction(boolean success) {
        if (success) {
            finish();
        }
    }
}
