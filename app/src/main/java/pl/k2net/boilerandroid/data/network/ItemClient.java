package pl.k2net.boilerandroid.data.network;

import java.util.List;

import retrofit.Response;

import pl.k2net.boilerandroid.data.entity.ItemEntity;
import retrofit.http.GET;
import rx.Observable;

public interface ItemClient {
    @GET(RestApi.EndPoint.ITEM)
    Observable<Response<List<ItemEntity>>> list();
}
