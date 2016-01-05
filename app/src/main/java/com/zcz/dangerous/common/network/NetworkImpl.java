package com.zcz.dangerous.common.network;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhaocz on 2016/1/5.
 */
public class NetworkImpl {

    private Context mContext;

    private NetworkCallBack callBack;

    public NetworkImpl(Context mContext, NetworkCallBack callBack) {
        this.mContext = mContext;
        this.callBack = callBack;
    }


    public void loadData(String url, RequestParams params, final RequestType reqType) {
        AsyncHttpClient client = MyAsyncHttpClient.createClient(mContext);

        JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                callBack.parseJson(response);
            }

        };

        switch (reqType) {
            case GET:
                break;
            case PUT:
                break;
            case POST:
                client.post(url, params, jsonHttpResponseHandler);
                break;
            case DELETE:
                break;
        }
    }

    public enum RequestType {
        GET,
        PUT,
        POST,
        DELETE
    }

}
