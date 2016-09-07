package com.oranle.sports.util;

/**
 * 
 * @ClassName: StringUtil
 * @Description: (字符串工具类)
 * @author: Oranle
 * @date: 2016年7月17日 下午2:11:43
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月17日 下午2:11:43
 */
public class StringUtil
{

    /**
     * 
     * @Title: isEmpty 
     * @Description: (判断字符是否为空) 
     * @最后修改人: Oranle
     * @最后修改时间: 2016年7月17日 下午2:13:30
     * @param content
     * @return 对方法的参数进行描述
     * @return: boolean 返回类型
     * @throws
     */
    public static boolean isEmpty(String content)
    {
        if (null == content || "".equals(content))
        {
            return true;
        }
        return false;
    }

}
