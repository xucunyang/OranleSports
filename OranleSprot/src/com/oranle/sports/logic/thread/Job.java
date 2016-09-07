package com.oranle.sports.logic.thread;

/**
 * @ClassName: Job
 * @Description: ()
 * @author: Oranle
 * @date: 2016年7月20日 下午9:09:45
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月20日 下午9:09:45
 */
public interface Job<T>
{
    public T run(JobContext jc);
}
