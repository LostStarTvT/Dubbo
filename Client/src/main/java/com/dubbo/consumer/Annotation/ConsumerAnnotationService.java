package com.dubbo.consumer.Annotation;

import com.alibaba.dubbo.config.annotation.Reference;

import com.dubbo.api.ProviderServiceAnnotation;
import org.springframework.stereotype.Component;

/**
 * @Classname consumerAnnotationService
 * @Description TODO  用户调用注解api的代理类。
 * @Date 2020/7/8 14:57
 * @Created by Seven
 */

@Component("annotatedConsumer")
public class ConsumerAnnotationService {

    // 这个就是直接调用provider的接口类，是如何进行发现的呢？
    @Reference
    private ProviderServiceAnnotation providerServiceAnnotation;

    public String doSayHello(String name) {
        return providerServiceAnnotation.SayHelloAnnotation(name);
    }
}
