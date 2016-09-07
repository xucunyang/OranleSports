package com.oranle.sports.logic.thread;

/**
 * @ClassName: FutureListener 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author: Oranle
 * @date: 2016年7月23日 下午1:19:40
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月23日 下午1:19:40
 */
public interface FutureListener<T>
{
    public void onFutureDone(Future<T> future);
}
