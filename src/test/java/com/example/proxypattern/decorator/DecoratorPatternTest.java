package com.example.proxypattern.decorator;

import com.example.proxypattern.decorator.code.Component;
import com.example.proxypattern.decorator.code.DecoratorPatternClient;
import com.example.proxypattern.decorator.code.MessageDecorator;
import com.example.proxypattern.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();

        MessageDecorator messageDecorator =
                new MessageDecorator(realComponent);

        DecoratorPatternClient client =
                new DecoratorPatternClient(messageDecorator);

        client.execute();
    }
}
