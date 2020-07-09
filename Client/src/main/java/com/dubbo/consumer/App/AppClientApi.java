package com.dubbo.consumer.App;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dubbo.api.ProviderService;

// 导入需要调用的服务，不需要自己在本地进行定义。

import java.io.IOException;

/**
 * @Classname AppApi
 * @Description TODO 使用纯java的方式进行配置  有个小bug 就是结果没有输出， 然后自己在那里进行瞎调卧槽
 *
 * @Date 2020/7/8 9:21
 * @Created by Seven
 */
public class AppClientApi {
    public static void main(String[] args) throws IOException {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("consumer");
//        application.setOwner("sihai");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://192.168.249.128:2181");
        registry.setUsername("dubbo");
        registry.setCheck(false);
        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<ProviderService> reference = new ReferenceConfig<ProviderService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(ProviderService.class);
        reference.setVersion("1.0.0");
        reference.setCheck(false);
        // 和本地bean一样使用xxxService
        ProviderService providerService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用

        // 真的蠢我说怎么会没有结果 原来是因为没有输出。。。卧槽了
        String result = providerService.SayHello("CCC");
        System.out.println(result);
    }
}
