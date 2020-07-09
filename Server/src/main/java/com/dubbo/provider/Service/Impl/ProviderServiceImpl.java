package com.dubbo.provider.Service.Impl;


import com.dubbo.api.ProviderService;

/**
 * @Classname ProviderServiceImpl
 * @Description TODO 使用xml和api方式进行测试。  具体的服务端的实现类
 * @Date 2020/7/7 20:21
 * @Created by Seven
 */
public class ProviderServiceImpl implements ProviderService {
    public String SayHello(String word) {
        return word;
    }
}
