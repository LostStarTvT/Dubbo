package com.dubbo.provider.App;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dubbo.api.ProviderService;
import com.dubbo.provider.Service.Impl.ProviderServiceImpl;

import java.io.IOException;

/**
 * @Classname AppServerApi
 * @Description TODO  使用java的方法进行启动。
 * @Date 2020/7/8 9:32
 * @Created by Seven
 */
public class AppServerApi {
    public static void main(String[] args) throws IOException {
        //需要实现的服务
        ProviderService providerService = new ProviderServiceImpl();

        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider");
//        applicationConfig.setOwner("sihai");

        // 连接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.249.128:2181");
        registryConfig.setCheck(false);
        // 服务协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(12345);


        // 服务提供者协议配置
        ServiceConfig<ProviderService> serviceConfig = new ServiceConfig<ProviderService>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(ProviderService.class);
        serviceConfig.setRef(providerService);
        serviceConfig.setVersion("1.0.0");

        serviceConfig.export();

        // 阻塞其停止
        System.in.read();
    }
}
