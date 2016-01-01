package pl.k2net.boilerandroid.di.module;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module
public class NetworkModule {

    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder,
                             HttpUrl baseUrl,
                             OkHttpClient okHttpClient) {
        return builder
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
