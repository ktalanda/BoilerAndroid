package pl.k2net.boilerandroid.di.module;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import pl.k2net.boilerandroid.data.network.RestApi;
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
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
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
