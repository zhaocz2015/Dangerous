package com.zcz.dangerous.common.widget;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by zhaocz on 2016/1/5.
 */
public class SingleToast {

    private Context mContext;
    private Toast mToast;

    public SingleToast(Context mContext) {
        this.mContext = mContext;
        mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
    }

    public void showMiddleToast(int msgId) {
        mToast.setText(msgId);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    public void showMiddleToast(String msgText) {
        mToast.setText(msgText);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    public void showBottomToast(int msgId) {
        mToast.setText(msgId);
        mToast.setGravity(Gravity.BOTTOM, 0, 64);
        mToast.show();
    }

    public void showBottomToast(String msgText) {
        mToast.setText(msgText);
        mToast.setGravity(Gravity.BOTTOM, 0, 64);
        mToast.show();
    }

}
