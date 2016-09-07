package com.oranle.sports.util;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * @ClassName: ToastUtil
 * @Description:
 * @author: Oranle
 * @date: 2016年8月1日 下午10:14:17
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月1日 下午10:14:17
 */
public class ToastUtil
{
    private static final String TAG = ToastUtil.class.getSimpleName();
    /**
     * 上次显示Toast时间
     */
    private static long lastShowTime = 0l;

    /**
     * 上次Toast显示的内容
     */
    private static String lastShowContent;

    /**
     * Toast弹框提示
     * @Title: showToast 
     * @Description: 
     * @最后修改人: Oranle
     * @最后修改时间: 2016年8月9日 下午9:39:31
     */
    public static void showToast(Activity activity, String content)
    {
        long nowTime = System.currentTimeMillis();

        if (nowTime - lastShowTime < 2000 && lastShowContent.equals(content))
        {
            return;
        }
        
        if (null != activity && !activity.isFinishing() && !StringUtil.isEmpty(content))
        {
            Toast.makeText(activity, content, Toast.LENGTH_SHORT).show();
            lastShowTime = System.currentTimeMillis();
            lastShowContent = content;
        }
    }
    
    /**
     * Toast弹框提示
     * @Title: showToast 
     * @Description: 
     * @最后修改人: Oranle
     * @最后修改时间: 2016年8月9日 下午9:39:58
     */
    public static void showToast(Activity activity, int resId)
    {
        String content = activity.getString(resId);
        showToast(activity, content);
    }
}
