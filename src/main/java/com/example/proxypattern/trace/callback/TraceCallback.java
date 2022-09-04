package com.example.proxypattern.trace.callback;

public interface TraceCallback<T> {
    T call();
}
