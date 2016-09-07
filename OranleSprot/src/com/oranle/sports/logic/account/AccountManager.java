package com.oranle.sports.logic.account;

/**
 * 账户管理类
 * @author: Oranle
 * @date: 2016年8月18日 下午10:15:42
 * @最后修改人: Oranle
 * @最后修改时间: 2016年8月18日 下午10:15:42
 */
public class AccountManager
{
    private static AccountManager sInstace;

    public static AccountManager getInstance()
    {
        if (null == sInstace)
        {
            sInstace = new AccountManager();
        }
        return sInstace;
    }
    
    public long getAccountId()
    {
        return 0;
    }
}
