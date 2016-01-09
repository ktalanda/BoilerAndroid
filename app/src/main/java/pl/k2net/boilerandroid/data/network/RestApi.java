package pl.k2net.boilerandroid.data.network;

import pl.k2net.boilerandroid.BuildConfig;

public interface RestApi {

    String SCHEME = BuildConfig.SCHEMA;
    String HOST = BuildConfig.HOST;

    interface EndPoint {
        String SIGNIN = "auth/signin";
        String ITEM = "item";
        String USERS = "users";
        String MIRROR = "mirror";
        String PING = "ping";
    }
    interface Query {
        String QUERY = "";
    }
}
