package com.oranle.sports.ui.activity;

import com.oranle.sports.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * 
 * @ClassName: MainActivity 
 * @Description: (主界面) 
 * @author: Oranle
 * @date: 2016年7月15日 下午8:00:49
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月15日 下午8:00:49
 */
public class MainActivity extends BaseActivity
{
    /**
     * handler
     */
    private InnerHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        createView();
        initView();
    }

    private void initView()
    {
    }

    /**
     * 
     */
    private void createView()
    {
        setContentView(R.layout.ora_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    }
    
    private static class InnerHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
        }
    }

}
