package com.oranle.sports.logic.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.util.Log;

/**
 * @ClassName: ThreadPool
 * @Description: (这里用一句话描述这个类的作用)
 * @author: Oranle
 * @date: 2016年7月20日 下午9:16:54
 * @最后修改人: Oranle
 * @最后修改时间: 2016年7月20日 下午9:16:54
 */
public class ThreadPool
{
    /*
     * 核心线程数量
     */
    private static final int CORE_POOL_SIZE = 4;

    /**
     * 最大线程数量
     */
    private static final int MAX_POOL_SIZE = 8;

    /**
     * 保活时间10s
     */
    private static final int KEEP_ALIVE_TIME = 10;

    /**
     * 线程执行管理
     */
    private final Executor mExecutor;

    /**
     * 单实例
     */
    private static ThreadPool mInstance;

    public static ThreadPool getInstance()
    {
        if (null == mInstance)
        {
            mInstance = new ThreadPool();
        }
        return mInstance;
    }

    public ThreadPool()
    {
        this(CORE_POOL_SIZE, MAX_POOL_SIZE);
    }

    /**
     * @Title: 构造函数
     * @Description: (描述构造函数实现的功能)
     * @param initPoolSize
     * @param maxPoolSize
     */
    public ThreadPool(int initPoolSize, int maxPoolSize)
    {
        mExecutor = new ThreadPoolExecutor(initPoolSize, maxPoolSize, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new PriorityThreadFactory("thread-pool", android.os.Process.THREAD_PRIORITY_BACKGROUND));
    }

    /**
     * @Title: submit
     * @Description:提交任务到线程池执行，并且在执行完第一个任务（Job）时候, 可以在listener回调里面急着做别的工作
     * @最后修改人:Oranle
     * @最后修改时间: 2016年7月23日 下午1:25:19
     * @return: Future<T>
     */
    public <T> Future<T> submit(Job<T> job, FutureListener<T> listener)
    {
        Worker<T> worker = new Worker<T>(job, listener);
        mExecutor.execute(worker);
        return worker;
    }

    public <T> Future<T> submit(Job<T> job)
    {
        return submit(job, null);
    }

    private static class Worker<T> implements Runnable, Future<T>, JobContext
    {
        /**
         * 日志TAG
         */
        private static final String TAG = "Worker";

        /**
         * 执行的任务
         */
        private Job<T> mJob;

        /**
         * 任务完成的回调监听
         */
        private FutureListener<T> mListener;

        /**
         * 取消执行任务监听
         */
        private CancelListener mCancelListener;

        /**
         * 任务取消的状态
         */
        private volatile boolean mIsCancelled;

        /**
         * 任务完成状态
         */
        private boolean mIsDone;

        /**
         * 任务执行获得的结果
         */
        private T mResult;

        /**
         * @Title: 构造函数
         * @Description: (描述构造函数实现的功能)
         * @param job
         * @param listener
         */
        public Worker(Job<T> job, FutureListener<T> listener)
        {
            this.mJob = job;
            this.mListener = listener;
        }

        @Override
        public void run()
        {
            T result = null;
            try
            {
                result = mJob.run(this);
            }
            catch (Throwable e)
            {
                Log.e(TAG, "Exception in running a Job", e);
            }
            synchronized (this)
            {
                mResult = result;
                mIsDone = true;
                notifyAll();
            }
            if (null != mListener)
            {
                mListener.onFutureDone(this);
            }
        }

        @Override
        public boolean isCancelled()
        {
            return mIsCancelled;
        }

        @Override
        public synchronized void setCancelListener(CancelListener listener)
        {
            this.mCancelListener = listener;
            // 为啥要加这一段？？？
            if (mIsCancelled && mCancelListener != null)
            {
                mCancelListener.onCancel();
            }
        }

        @Override
        public void cancel()
        {
            if (mIsCancelled)
            {
                return;
            }
            mIsCancelled = true;
            if (null != mCancelListener)
            {
                mCancelListener.onCancel();
            }
        }

        @Override
        public boolean isCanceled()
        {
            return mIsCancelled;
        }

        @Override
        public boolean isDone()
        {
            return mIsDone;
        }

        @Override
        public synchronized T get()
        {
            while (!mIsDone)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    Log.e(TAG, "Exception in wait", e);
                }
            }
            return mResult;
        }

        @Override
        public void waitDone()
        {
            get();
        }
    }

}
