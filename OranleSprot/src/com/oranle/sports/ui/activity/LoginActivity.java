package com.oranle.sports.ui.activity;

import com.oranle.sports.R;
import com.oranle.sports.logic.login.LoginManager;
import com.oranle.sports.logic.login.LoginManager.LoginCallback;
import com.oranle.sports.logic.model.User;
import com.oranle.sports.util.StringUtil;
import com.oranle.sports.util.ToastUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @Description: 登录界面
 * @author: Oranle
 * @date: 2016年8月9日 下午9:11:03
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月9日 下午9:11:03
 */
public class LoginActivity extends Activity implements OnClickListener
{
    
    private static final String TAG = LoginActivity.class.getSimpleName();
    /**
     * 账号输入框
     */
    private EditText accountEditText;

    /**
     * 密码输入框
     */
    private EditText passWordEditText;

    /**
     * 登录按钮
     */
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ora_login_layout);
        initView();
    }

    /**
     * 初始化view控件
     * 
     * @Title: initView
     * @Description:
     * @最后修改人: Oranle
     * @最后修改时间:2016年8月9日 下午9:30:34
     * @return: void
     */
    private void initView()
    {
        accountEditText = (EditText) findViewById(R.id.ora_account_et);
        passWordEditText = (EditText) findViewById(R.id.ora_password_et);
        loginButton = (Button) findViewById(R.id.ora_login_btn);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String account = accountEditText.getText().toString();
        String password = passWordEditText.getText().toString();
        if (StringUtil.isEmpty(account))
        {
            ToastUtil.showToast(this, getString(R.string.ora_account_is_empty));
            return;
        }
        if (StringUtil.isEmpty(password))
        {
            ToastUtil.showToast(this, getString(R.string.ora_password_is_empty));
            return;
        }
        User user = new User();
        user.setNickName(account);
        LoginManager.getLoginManager(this).setLoginParam(user, new LoginCallback()
        {

            @Override
            public void onLoginSuccess(String text)
            {
                ToastUtil.showToast(LoginActivity.this, "login success " + text);
//                Log.d(TAG, "login success : " + text);
            }

            @Override
            public void onLoginFailed()
            {
                ToastUtil.showToast(LoginActivity.this, "login failed");
            }
        });
        LoginManager.getLoginManager(this).login();

    }
}
