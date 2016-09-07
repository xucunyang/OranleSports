package com.oranle.sports.logic.login;

import java.util.List;

import com.oranle.sports.logic.db.helper.UserDBHelper;
import com.oranle.sports.logic.model.User;
import com.oranle.sports.logic.thread.Future;
import com.oranle.sports.logic.thread.FutureListener;
import com.oranle.sports.logic.thread.Job;
import com.oranle.sports.logic.thread.JobContext;
import com.oranle.sports.logic.thread.ThreadPool;
import com.oranle.sports.util.HttpUtil;

import android.content.Context;
import android.util.Log;

/**
 * @ClassName: LoginManager 
 * @Description: 登录管理类
 * @author: Oranle
 * @date: 2016年8月9日 下午9:50:23
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月9日 下午9:50:23
 */
public class LoginManager
{
    private static final String TAG = LoginManager.class.getSimpleName();
    /**
     * 
     * @ClassName: LoginCallback 
     * @Description: 登录回调接口
     * @author: Oranle
     * @date: 2016年8月9日 下午9:53:59
     * @最后修改人: Oranle
     * @最后修改时间: 2016年8月9日 下午9:53:59
     */
    public interface LoginCallback
    {
        /**
         * 登录成功
         */
        public void onLoginSuccess(String text);

        /**
         * 登录失败
         */
        public void onLoginFailed();
    }

    /**
     * 登录监听器
     */
    private LoginCallback loginListener;
    
    /**
     * 上下文
     */
    private Context context;

    /**
     * 登录用户信息
     */
    private User user;

    /**
     * 单例
     */
    private static LoginManager sInstance;

    public static synchronized LoginManager getLoginManager(Context context)
    {
        if (null == sInstance)
        {
            sInstance = new LoginManager(context);
        }
        return sInstance;
    }
    
    
    public LoginManager(Context context)
    {
        this.context = context;
    }

    /**
     * @Description:  设置登录监听
     * @最后修改时间: 2016年8月9日 下午10:01:18
     */
    public LoginManager setLoginParam(User user, LoginCallback loginListener)
    {
        this.loginListener = loginListener;
        this.user = user;
        return this;
    }
    
    public void login()
    {
        
        if(null == user || null == loginListener) 
        {
            return;
        }
        
        if(null != user) 
        {
            String response = HttpUtil.doGet("http://192.168.0.109:8081/webService?wsdl");
            Log.i(TAG, "======: " + response);
            return;
        }
        user.setAge(11);
        user.setCity("南京");
        user.setGender(0);
        user.setHeadImageURL("www.baidu.com");
        user.setSignture("谎言说了一千遍就是真理");
        user.setUID(1000120000122l);
        ThreadPool.getInstance().submit(new Job<Integer>()
        {

            @Override
            public Integer run(JobContext jc)
            {
                UserDBHelper.getInstance(context).insert(user);
                return Integer.valueOf(22);
            }
        }, new FutureListener<Integer>()
        {

            @Override
            public void onFutureDone(Future<Integer> future)
            {
                StringBuffer sb = new StringBuffer();
                List<User> users = UserDBHelper.getInstance(context).getAllUser();
                for(User user : users)
                {
                    sb.append(user.getAge());
                    sb.append(", ");
                    sb.append(user.getCity());
                    sb.append(", ");
                    sb.append(user.getGender());
                    sb.append(", ");
                    sb.append(user.getHeadImageURL());
                    sb.append(", ");
                    sb.append(user.getNickName());
                    sb.append(", ");
                    sb.append(user.getSignture());
                    sb.append(", ");
                    sb.append(user.getUID());
                    sb.append(", ");

                }
                sb.append("future get: " + future.get());
                loginListener.onLoginSuccess(sb.toString());
            }
        });

        
        
        
    }
}
