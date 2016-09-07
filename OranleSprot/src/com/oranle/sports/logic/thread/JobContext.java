package com.oranle.sports.logic.thread;

public interface JobContext
{
    boolean isCancelled();

    void setCancelListener(CancelListener listener);
}
