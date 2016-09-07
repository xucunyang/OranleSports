package com.oranle.sports.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 
 * @ClassName: BaseActivity
 * @Description: (父类Activity)
 * @author: Oranle
 * @date: 2016年7月15日 下午8:05:52
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月15日 下午8:05:52
 */
public class BaseActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    protected void onStop()
    {
    };

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
    }
}
