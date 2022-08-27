package com.example.proxypattern.app.v3;

import org.springframework.stereotype.Service;

@Service    // ComponentScan 의 대상, 이유: @서비스 어노테이션 안에 @Component 포함되어 있다.
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;

    public OrderServiceV3(OrderRepositoryV3 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
