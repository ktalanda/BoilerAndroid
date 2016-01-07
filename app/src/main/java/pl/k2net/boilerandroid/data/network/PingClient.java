package pl.k2net.boilerandroid.data.network;

import retrofit.Response;
import retrofit.http.GET;
import rx.Observable;

public interface PingClient {

    @GET(RestApi.EndPoint.PING)
    Observable<Response<String>> ping();

}
