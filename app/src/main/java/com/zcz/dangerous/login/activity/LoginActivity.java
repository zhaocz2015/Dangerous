package com.zcz.dangerous.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.RequestParams;
import com.zcz.dangerous.MainActivity;
import com.zcz.dangerous.MainActivity_;
import com.zcz.dangerous.R;
import com.zcz.dangerous.common.activity.BaseActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.json.JSONObject;

/**
 * Created by zhaocz on 2016/1/4.
 */
@EActivity(R.layout.login_activity)
public class LoginActivity extends BaseActivity {

    @ViewById(R.id.editText_username)
    EditText userEditText;

    @ViewById(R.id.edtiText_password)
    EditText paswEditText;


    @Click(R.id.button_login)
    public void login(View v) {

        // 用户名和密码非空校验
        String username = userEditText.getText().toString();
        if (TextUtils.isEmpty(username)) {
            showBottomToast("账号不可为空");
            return;
        }

        String password = paswEditText.getText().toString();
        if (TextUtils.isEmpty(password)) {
            showBottomToast("密码不可为空");
            return;
        }

//        RequestParams params = new RequestParams();
//        params.put("username", username);
//        params.put("password", password);
//        postNetwork("", params);

//        showProgressDialog("正在登陆...");
        startActivity(new Intent(LoginActivity.this, MainActivity_.class));
//        hideProgressDialog();
    }

    @Override
    public void parseJson(JSONObject reponse) {
        hideProgressDialog();
        finish();
//        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}