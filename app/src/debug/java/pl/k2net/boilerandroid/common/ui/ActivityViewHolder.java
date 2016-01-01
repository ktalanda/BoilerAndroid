package pl.k2net.boilerandroid.common.ui;

import android.widget.FrameLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.k2net.boilerandroid.BuildConfig;
import pl.k2net.boilerandroid.R;

public class ActivityViewHolder {

    @Bind(R.id.debug_container)
    FrameLayout content;

    @Bind(R.id.setting_debug_version)
    TextView version;

    @Inject
    ActivityViewHolder() {
    }

    ActivityViewHolder withBoundViews(BaseActivity baseActivity) {
        ButterKnife.bind(this, baseActivity);
        version.setText(BuildConfig.VERSION_NAME);

        return this;
    }
}
