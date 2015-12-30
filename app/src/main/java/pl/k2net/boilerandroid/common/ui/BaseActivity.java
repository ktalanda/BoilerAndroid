package pl.k2net.boilerandroid.common.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import pl.k2net.boilerandroid.MyApplication;
import pl.k2net.boilerandroid.di.ActivityComponent;
import pl.k2net.boilerandroid.di.ActivityComponentProvider;

public class BaseActivity extends AppCompatActivity
        implements ActivityComponentProvider {

    @Inject
    AppContainer appContainer;

    private ActivityComponent activityComponent;

    protected void bindContentView(int layoutRes) {
        final ViewGroup container = appContainer.bind(this);
        getLayoutInflater().inflate(layoutRes, container);
        ButterKnife.bind(this, container);
    }

    @Override
    public ActivityComponent initActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ActivityComponent
                    .Initializer
                    .init(MyApplication.component(this));
        }
        return activityComponent;
    }
}
