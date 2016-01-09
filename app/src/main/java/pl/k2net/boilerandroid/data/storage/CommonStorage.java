package pl.k2net.boilerandroid.data.storage;

import android.content.Context;
import android.preference.PreferenceManager;

import java.util.HashSet;

import javax.inject.Inject;

public class CommonStorage {

    private static final String PREF_COOKIES = "cookies";

    Context context;

    @Inject
    public CommonStorage(Context baseActivity) {
        this.context = baseActivity;
    }

    public void storeCookies(HashSet<String> cookies) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putStringSet(PREF_COOKIES, cookies)
                .apply();
    }

    public HashSet<String> getCookies() {
        return (HashSet<String>) PreferenceManager.getDefaultSharedPreferences(context)
                .getStringSet(PREF_COOKIES, new HashSet<>());
    }

}
