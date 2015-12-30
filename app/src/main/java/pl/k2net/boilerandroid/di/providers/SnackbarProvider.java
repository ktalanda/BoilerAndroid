package pl.k2net.boilerandroid.di.providers;

import android.support.design.widget.Snackbar;
import android.view.View;

import javax.inject.Inject;

public class SnackbarProvider {

    @Inject
    SnackbarProvider() {
    }

    public Snackbar get(View view, String text, int length) {
        return Snackbar.make(view, text, length);
    }

}
