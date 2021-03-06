package pl.k2net.boilerandroid.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.Bind;
import butterknife.OnClick;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.BaseActivity;
import pl.k2net.boilerandroid.di.providers.SnackbarProvider;
import pl.k2net.boilerandroid.di.qualifiers.LoginIntent;
import pl.k2net.boilerandroid.item.adapter.ItemAdapter;
import pl.k2net.boilerandroid.item.fragment.ItemFragment;
import pl.k2net.boilerandroid.main.ui.menu.DrawerMenu;
import pl.k2net.boilerandroid.main.ui.menu.DrawerMenuAdapter;
import pl.k2net.boilerandroid.main.ui.menu.view.DrawerHeaderView;
import pl.k2net.boilerandroid.presentation.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainPresenter.ViewInterface {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer)
    DrawerLayout drawer;
    @Bind(R.id.drawer_list)
    RecyclerView drawerList;

    @Inject
    ItemAdapter adapter;
    @Inject
    SnackbarProvider snackbarProvider;
    @Inject
    Provider<RecyclerView.LayoutManager> linearLayoutManagerProvider;
    @Inject
    DrawerMenuAdapter drawerMenuAdapter;

    @LoginIntent
    @Inject
    Intent loginIntent;
    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initActivityComponent().inject(this);
        presenter.bind(this);
        super.onCreate(savedInstanceState);
        bindContentView(R.layout.activity_main, savedInstanceState);
        setUpToolbar();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, new ItemFragment())
                .commit();

        for (DrawerMenu mainMenu : DrawerMenu.values()) {
            drawerMenuAdapter.addItem(mainMenu);
        }
        drawerMenuAdapter.setHeaderView(new DrawerHeaderView() {
            @Override
            public int username() {
                return R.string.app_name;
            }
        });
        drawerList.setLayoutManager(linearLayoutManagerProvider.get());
        drawerList.setAdapter(drawerMenuAdapter);
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
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        }
    }

    @OnClick(R.id.logout)
    public void onLogoutClick(View view) {
        presenter.signout();
    }

    @Override
    public void signoutAction(boolean success) {
        if (success) {
            finish();
            startActivity(loginIntent);
        }
    }
}
