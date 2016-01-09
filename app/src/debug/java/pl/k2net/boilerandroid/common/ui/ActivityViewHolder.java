package pl.k2net.boilerandroid.common.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
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
    @Bind(R.id.debug_build_name)
    TextView buildName;
    @Bind(R.id.debug_build_code)
    TextView buildCode;
    @Bind(R.id.debug_build_sha)
    TextView gitSha;
    @Bind(R.id.debug_build_date)
    TextView buildDate;
    @Bind(R.id.debug_device_make)
    TextView deviceMake;
    @Bind(R.id.debug_device_model)
    TextView deviceModel;
    @Bind(R.id.debug_device_resolution)
    TextView deviceResolution;
    @Bind(R.id.debug_device_density)
    TextView deviceDensity;
    @Bind(R.id.debug_device_release)
    TextView deviceRelease;
    @Bind(R.id.debug_device_api)
    TextView deviceApi;
    @Bind(R.id.debug_network_schema)
    TextView networkSchema;
    @Bind(R.id.debug_network_host)
    TextView networkHost;

    @Bind(R.id.debug_drawer)
    DrawerLayout drawerLayout;

    @Inject
    ActivityViewHolder() {
    }

    ActivityViewHolder withBoundViews(BaseActivity baseActivity,
                                      Bundle savedInstanceState) {
        ButterKnife.bind(this, baseActivity);
        if (savedInstanceState != null
                && savedInstanceState
                .getBoolean(AppContainerImpl.BUNDLE_DRAWER_OPEN)) {
            drawerLayout.openDrawer(GravityCompat.END);
        }
        DisplayMetrics displayMetrics = baseActivity.getResources()
                .getDisplayMetrics();
        buildName.setText(BuildConfig.VERSION_NAME);
        buildCode.setText(
                String.format(
                        baseActivity.getString(R.string.debug_drawer_build_code_value),
                        BuildConfig.VERSION_CODE));
        gitSha.setText(BuildConfig.GIT_SHA);
        buildDate.setText(BuildConfig.BUILD_TIME);
        deviceMake.setText(Build.MANUFACTURER);
        deviceModel.setText(Build.MODEL);
        deviceResolution.setText(
                String.format(
                        baseActivity.getString(R.string.debug_drawer_device_resolution_value),
                        displayMetrics.heightPixels, displayMetrics.widthPixels));
        deviceDensity.setText(
                String.format(
                        baseActivity.getString(R.string.debug_drawer_device_density_value),
                        displayMetrics.densityDpi, getDensityString(displayMetrics)));
        deviceRelease.setText(Build.VERSION.RELEASE);
        deviceApi.setText(String.valueOf(Build.VERSION.SDK_INT));
        networkSchema.setText(BuildConfig.SCHEMA);
        networkHost.setText(BuildConfig.HOST);
        return this;
    }

    public boolean isDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.END);
    }

    private static String getDensityString(DisplayMetrics displayMetrics) {
        switch (displayMetrics.densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                return "ldpi";
            case DisplayMetrics.DENSITY_MEDIUM:
                return "mdpi";
            case DisplayMetrics.DENSITY_HIGH:
                return "hdpi";
            case DisplayMetrics.DENSITY_XHIGH:
                return "xhdpi";
            case DisplayMetrics.DENSITY_XXHIGH:
                return "xxhdpi";
            case DisplayMetrics.DENSITY_XXXHIGH:
                return "xxxhdpi";
            case DisplayMetrics.DENSITY_TV:
                return "tvdpi";
            default:
                return String.valueOf(displayMetrics.densityDpi);
        }
    }
}
