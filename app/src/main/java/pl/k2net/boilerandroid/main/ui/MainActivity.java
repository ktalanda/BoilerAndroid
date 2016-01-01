package pl.k2net.boilerandroid.main.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.BaseActivity;
import pl.k2net.boilerandroid.di.providers.SnackbarProvider;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    SnackbarProvider snackbarProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initActivityComponent().inject(this);
        super.onCreate(savedInstanceState);
        bindContentView(R.layout.activity_main, savedInstanceState);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onSaveInstanceState(Bundle outState,
                                    PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        saveInstanceState(outState);
    }

    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        snackbarProvider
                .get(view, "test", Snackbar.LENGTH_SHORT)
                .setAction("Action", null)
                .show();
    }

}
