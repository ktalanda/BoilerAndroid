package pl.k2net.boilerandroid.di.module;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.data.network.RestApi;
import pl.k2net.boilerandroid.data.network.interceptor.AddCookiesInterceptor;
import pl.k2net.boilerandroid.data.network.interceptor.ReceivedCookiesInterceptor;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class NetworkModule {

    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    HttpUrl.Builder provideHttpUrlBuilder() {
        return new HttpUrl.Builder();
    }

    @Provides
    HttpUrl provideHttpUrl(HttpUrl.Builder builder) {
        return builder
                .scheme(RestApi.SCHEME)
                .host(RestApi.HOST)
                .build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(AddCookiesInterceptor addCookiesInterceptor,
                                     ReceivedCookiesInterceptor receivedCookiesInterceptor) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(addCookiesInterceptor);
        okHttpClient.interceptors().add(receivedCookiesInterceptor);
        return okHttpClient;
    }

    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder,
                             HttpUrl baseUrl,
                             OkHttpClient okHttpClient) {
        return builder
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
