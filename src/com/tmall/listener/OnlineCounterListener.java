package com.tmall.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class OnlineCounterListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        OnlineCounter.raise();
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        OnlineCounter.reduce();
    }
}