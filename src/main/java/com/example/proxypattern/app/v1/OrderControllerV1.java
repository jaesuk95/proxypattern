package com.example.proxypattern.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 지금까지 controller, Service, Repository 에 인터페이스를 도입하고 스프링 빈으로 수동 등록해보았다
 * */


@RequestMapping // 스프링은 @Controller 또는 @RequestMapping 이 있어야 스프링 controller 으로 인식
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/v1/request")  // log 를 사용할 대상
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
