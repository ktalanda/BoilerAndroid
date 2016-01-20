package pl.k2net.boilerandroid.presentation.presenter;

import lombok.Getter;

public class BasePresenter<V> {
    @Getter private V view;

    public void bind(V view) {
        if (this.view != null) {
            throw new RuntimeException("Concurrent view bind! Unexpected, second instance of view occurred"
                    + " before first one unbind.");
        }
        this.view = view;
    }

}
