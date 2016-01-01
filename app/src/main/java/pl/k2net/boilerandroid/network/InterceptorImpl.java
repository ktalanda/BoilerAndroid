package pl.k2net.boilerandroid.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;

import pl.k2net.boilerandroid.network.logic.AuthManager;

public class InterceptorImpl implements Interceptor {

    private static final String AUTHORIZATION = "Authorization";

    private final AuthManager authManager;

    @Inject
    InterceptorImpl(AuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request())
                .newBuilder()
                .header(AUTHORIZATION, authManager.getToken())
                .build();
    }
}
