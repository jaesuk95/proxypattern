package com.example.proxypattern.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        // 공통 로직1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result={}", result1);
        // 공통 로직1 종료

        // 공통 로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result={}", result2);
        // 공통 로직2 종료
    }

    @Test
    void reflection1() throws Exception {
        //클래스 정보
        Class classHello = Class.forName("com.example.proxypattern.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        // callA
        Method methodCallA = classHello.getMethod("callA"); // 문자로 메서드를 호출한다
        Object result1 = methodCallA.invoke(target); // target 에 있는 인스턴스를 불러온다
        log.info("result={}",result1);

        // callB
        Method methodCallB = classHello.getMethod("callB"); // 문자로 메서드를 호출한다
        Object result2 = methodCallA.invoke(target); // target 에 있는 인스턴스를 불러온다
        log.info("result={}",result2);
    }

    @Test
    void reflection2() throws Exception {
        //클래스 정보
        Class classHello = Class.forName("com.example" +
                ".proxypattern.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCallA = classHello.getMethod("callA"); // 문자로 메서드를 호출한다
        dynamicCall(methodCallA,target);

        Method methodCallB = classHello.getMethod("callB"); // 문자로 메서드를 호출한다
        dynamicCall(methodCallB,target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        // 공통 로직1 시작
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }
        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
