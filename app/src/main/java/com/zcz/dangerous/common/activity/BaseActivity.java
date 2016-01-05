package com.zcz.dangerous.common.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.loopj.android.http.RequestParams;
import com.zcz.dangerous.common.network.NetworkCallBack;
import com.zcz.dangerous.common.network.NetworkImpl;
import com.zcz.dangerous.common.widget.SingleToast;

import org.json.JSONObject;

/**
 * Created by zhaocz on 2016/1/5.
 */
public class BaseActivity extends AppCompatActivity implements NetworkCallBack {

    private SingleToast mSingleToast;

    private ProgressDialog mProgressDialog;

    private NetworkImpl networkImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSingleToast();
        initProgressDialog();
        initNetwork();
    }

    @Override
    protected void onDestroy() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }

        super.onDestroy();
    }

    private void initSingleToast() {
        mSingleToast = new SingleToast(this);
    }

    public void showMiddleToast(int msgId) {
        mSingleToast.showMiddleToast(msgId);
    }

    public void showMiddleToast(String msgText) {
        mSingleToast.showMiddleToast(msgText);
    }

    public void showBottomToast(int msgId) {
        mSingleToast.showBottomToast(msgId);
    }

    public void showBottomToast(String msgText) {
        mSingleToast.showBottomToast(msgText);
    }

    private void initProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
    }

    public void showProgressDialog(int msgId) {
        String msgText = getString(msgId);
        showProgressDialog(msgText);
    }

    public void showProgressDialog(String msgText) {
        mProgressDialog.setMessage(msgText);
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.hide();
        }
    }

    private void initNetwork() {
        networkImpl = new NetworkImpl(this, this);
    }

    public void postNetwork(String url, RequestParams params) {
        networkImpl.loadData(url, params, NetworkImpl.RequestType.POST);
    }

    public void getNetwork(String url, RequestParams params) {
        networkImpl.loadData(url, params, NetworkImpl.RequestType.GET);
    }

    public void putNetwork(String url, RequestParams params) {
        networkImpl.loadData(url, params, NetworkImpl.RequestType.PUT);
    }

    public void deleteNetwork(String url, RequestParams params) {
        networkImpl.loadData(url, params, NetworkImpl.RequestType.DELETE);
    }

    @Override
    public void parseJson(JSONObject reponse) {

    }
}
