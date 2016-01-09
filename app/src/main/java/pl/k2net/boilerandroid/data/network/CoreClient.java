package pl.k2net.boilerandroid.data.network;

import java.util.Map;

import retrofit.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

public interface CoreClient {

    @GET(RestApi.EndPoint.PING)
    Observable<Response<String>> ping();

    @POST(RestApi.EndPoint.MIRROR)
    Observable<Response<Map<String, String>>> mirror(@Body Map<String, String> body);

}
