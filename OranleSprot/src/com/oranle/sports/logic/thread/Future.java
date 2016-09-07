package com.oranle.sports.logic.thread;

/**
 * @ClassName: Future 
 * @Description: () 
 * @author: Oranle
 * @date: 2016年7月23日 下午1:10:34
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月23日 下午1:10:34
 */
public interface Future<T>
{
    /**
     * @Title: cancel 
     * @Description: (取消) 
     * @最后修改人: Oranle
     * @最后修改时间: 2016年7月23日 下午1:11:00 对方法的参数进行描述
     * @return: void 返回类型
     * @throws
     */
    public void cancel();

    /**
     * @Title: isCanceled 
     * @Description: (返回当前任务取消的状态) 
     * @最后修改人: Oranle
     * @最后修改时间: 2016年7月23日 下午1:11:33
     * @return 对方法的参数进行描述
     * @return: boolean 返回类型
     * @throws
     */
    public boolean isCanceled();

    /**
     * @Title: isDone 
     * @Description: (当前任务是否完成) 
     * @最后修改人: Oranle
     * @最后修改时间: 2016年7月23日 下午1:12:13
     * @return 对方法的参数进行描述
     * @return: boolean 返回类型
     * @throws
     */
    public boolean isDone();

    /**
     * @Title: get 
     * @Description: 获取Job任务返回的值
     * @最后修改人: Oranle
     * @最后修改时间: 2016年7月23日 下午1:12:49
     * @return 对方法的参数进行描述
     * @return: T 返回类型
     * @throws
     */
    public T get();

    /**
     * @Title: waitDone 
     * @Description: 
     * @最后修改人: Oranle
     * @最后修改时间: 2016年7月23日 下午1:16:19
     * @return: void
     * @throws
     */
    public void waitDone();
}
