package pl.k2net.boilerandroid.network;

import pl.k2net.boilerandroid.BuildConfig;

public interface RestApi {

    String SCHEME = "http";
    String HOST = BuildConfig.HOST;

    interface EndPoint {
        String END_POINT = "";
    }
    interface Query {
        String QUERY = "";
    }
}
