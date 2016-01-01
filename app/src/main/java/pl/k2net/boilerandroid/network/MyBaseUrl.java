package pl.k2net.boilerandroid.network;

import com.squareup.okhttp.HttpUrl;

import javax.inject.Inject;

import retrofit.BaseUrl;

public class MyBaseUrl implements BaseUrl {

    HttpUrl httpUrl;

    @Inject
    public MyBaseUrl(HttpUrl httpUrl) {
        this.httpUrl = httpUrl;
    }

    @Override
    public HttpUrl url() {
        return httpUrl;
    }
}
