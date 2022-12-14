package com.example.proxypattern;

import com.example.proxypattern.config.AppV1Config;
import com.example.proxypattern.config.AppV2Config;
import com.example.proxypattern.config.v1_proxy.ConcreteProxyConfig;
import com.example.proxypattern.config.v1_proxy.InterfaceProxyConfig;
import com.example.proxypattern.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import com.example.proxypattern.trace.logtrace.LogTrace;
import com.example.proxypattern.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)      // 클래스를 스프링 빈으로 등록한다. 여기서는 AppV1Config.class 를 스프링 빈으로 등록한다.
                                // 일반적으로 @Configuration 같은 설정 파일을 등록할 때 사용하지만, 스프링 빈을 등록할 떄도 사용할 수 있다.


//@Import(ConcreteProxyConfig.class)
@Import(DynamicProxyBasicConfig.class)
@SpringBootApplication(scanBasePackages = "com.example.proxypattern.app")
//@SpringBootApplication(scanBasePackages = "com.example.proxypattern.app")
public class ProxypatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxypatternApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}

//@Import({AppV1Config.class,AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
