package com.dubbo.consumer.App;

import com.dubbo.consumer.Annotation.ConsumerAnnotationService;
import com.dubbo.consumer.configuration.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname AppAnnotation
 * @Description TODO 使用注解方式进行配置dubbo。
 * @Date 2020/7/8 15:03
 * @Created by Seven
 */
public class AppAnnotationClient {
    public static void main(String[] args) {
        //
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start(); // 启动
        ConsumerAnnotationService consumerAnnotationService = context.getBean(ConsumerAnnotationService.class);
        String hello = consumerAnnotationService.doSayHello("annotation + 1"); // 调用方法
        System.out.println("result: " + hello); // 输出结果
    }
}
