package pl.k2net.boilerandroid.data.network.interceptor;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashSet;

import javax.inject.Inject;

import pl.k2net.boilerandroid.data.storage.CommonStorage;

public class ReceivedCookiesInterceptor implements Interceptor {

    @Inject
    CommonStorage storage;

    @Inject
    public ReceivedCookiesInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (!response.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            for (String cookie : response.headers("Set-Cookie")) {
                cookies.add(cookie);
            }
            storage.storeCookies(cookies);
        }
        return response;
    }
}
