package com.example.proxypattern.app.v3;

import org.springframework.stereotype.Repository;

@Repository // Repository 안에는 Component 어노테이션이 있으며 ComponentScan 시 자동으로 스캔한다
public class OrderRepositoryV3 {
    public void save(String itemId) {
        // save logic
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }
}
