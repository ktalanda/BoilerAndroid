package pl.k2net.boilerandroid.data.network.interceptor;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.storage.CommonStorage;

public class AddCookiesInterceptor implements Interceptor {

    @Inject
    CommonStorage storage;

    @Inject
    AddCookiesInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        for (String cookie : storage.getCookies()) {
            builder.addHeader("Cookie", cookie);
        }
        return chain.proceed(builder.build());
    }
}
