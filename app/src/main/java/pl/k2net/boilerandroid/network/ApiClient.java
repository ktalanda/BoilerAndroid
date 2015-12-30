package pl.k2net.boilerandroid.network;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface ApiClient {

    @GET(RestApi.EndPoint.END_POINT)
    Observable<String> getTest(
            @Query(RestApi.Query.QUERY) String test
    );
}
