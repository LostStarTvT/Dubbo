package com.dubbo.consumer.App;


// 这个导入是怎么回事？？ 怎么就导进来了卧槽 不需要自己去写，然后从zookeeper导进来？

import com.dubbo.api.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Classname App
 * @Description TODO 使用配置文件的方式进行测试dubbo，直接运行就可以输出hello。
 * @Date 2020/7/7 21:31
 * @Created by Seven
 */
public class AppClient {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String str = providerService.SayHello("hello");
        System.out.println(str);
        System.in.read();
    }
}
