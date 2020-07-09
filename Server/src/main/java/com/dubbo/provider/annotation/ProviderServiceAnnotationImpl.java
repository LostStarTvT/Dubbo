package com.dubbo.provider.annotation;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.ProviderServiceAnnotation;

/**
 * @Classname ProviderServiceAnnotationImpl
 * @Description TODO 注解的实现类。
 * @Date 2020/7/8 14:44
 * @Created by Seven
 */
@Service(timeout = 5000)
public class ProviderServiceAnnotationImpl implements ProviderServiceAnnotation {
    public String SayHelloAnnotation(String word) {
        return word;
    }
}
