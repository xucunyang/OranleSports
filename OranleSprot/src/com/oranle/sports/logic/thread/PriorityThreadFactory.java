package com.oranle.sports.logic.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import android.os.Process;

/**
 * @ClassName: PriorityThreadFactory
 * @Description: (线程工厂)
 * @author: Oranle
 * @date: 2016年7月20日 下午9:37:34
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月20日 下午9:37:34
 */
public class PriorityThreadFactory implements ThreadFactory
{
    /**
     * 优先级
     */
    private final int mPriority;

    private final AtomicInteger mNumber = new AtomicInteger();

    /**
     * 线程名称
     */
    private final String mName;

    public PriorityThreadFactory(String name, int priority)
    {
        this.mName = name;
        this.mPriority = priority;
    }

    @Override
    public Thread newThread(Runnable r)
    {
        return new Thread(r, mName + '-' + mNumber.getAndIncrement())
        {
            @Override
            public void run()
            {
                Process.setThreadPriority(mPriority);
                super.run();
            }
        };
    }

}
