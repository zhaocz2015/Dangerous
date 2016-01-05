package com.zcz.dangerous.common.network;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;

/**
 * Created by zhaocz on 2016/1/5.
 */
public class MyAsyncHttpClient {

    public static void init(Context mContext) {

    }

    public static AsyncHttpClient createClient(Context context) {
        AsyncHttpClient client = new AsyncHttpClient();
//        PersistentCookieStore cookieStore = new PersistentCookieStore(context);
//        client.setCookieStore(cookieStore);

        return client;
    }

}
