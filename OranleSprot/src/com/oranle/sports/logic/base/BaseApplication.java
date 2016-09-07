package com.oranle.sports.logic.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class BaseApplication extends Application
{
    static Context _context;

    static Resources _resources;

    @Override
    public void onCreate()
    {
        super.onCreate();
        _context = getApplicationContext();
        _resources = _context.getResources();
    }

    
}
