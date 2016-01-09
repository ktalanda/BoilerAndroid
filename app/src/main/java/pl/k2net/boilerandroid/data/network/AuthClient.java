package pl.k2net.boilerandroid.data.network;

import pl.k2net.boilerandroid.data.entity.UserEntity;
import pl.k2net.boilerandroid.data.network.dto.AuthDTO;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

public interface AuthClient {
    @POST(RestApi.EndPoint.SIGNIN)
    Observable<UserEntity> signin(@Body AuthDTO authData);
}
