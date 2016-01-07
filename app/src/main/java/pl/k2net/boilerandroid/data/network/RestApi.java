package pl.k2net.boilerandroid.data.network;

import pl.k2net.boilerandroid.BuildConfig;

public interface RestApi {

    String SCHEME = "https";
    String HOST = BuildConfig.HOST;

    interface EndPoint {
        String USERS = "users";
        String PING = "ping";
    }
    interface Query {
        String QUERY = "";
    }
}
