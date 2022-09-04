package com.example.proxypattern.trace.logtrace;

import com.example.proxypattern.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
