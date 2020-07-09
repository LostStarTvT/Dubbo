# Dubbo

本项目主要是参考两篇博客：[Dubbo 一篇文章就够了：从入门到实战](https://segmentfault.com/a/1190000019896723)   [dubbo入门教程-从零搭建dubbo服务](https://www.cnblogs.com/ibigboy/p/10954791.html) 还有[Dubbo官方](http://dubbo.apache.org/zh-cn/docs/user/configuration/annotation.html) ，基于以上实现了使用XML、API、注解的方式进行构建dubbo项目。其中本项目使用Zookeeper进行服务的管理、注册与发现。

# 目录说明

在之前进行构建自己简单的RPC项目的时候，就发现之前如果在调用的时候，需要知道对方接口，然后进行使用网络进行动态代理调用服务器端的实现类。在进行开发dubbo的时候，就需要定义一个公共的API供服务器端和客户端进行调用，具体的架构说明：

![dubbo.png](https://pic.tyzhang.top/images/2020/07/09/dubbo.png)



在这里进行了模块化开发， 首先需要在ServicApi定义好二者需要的接口，然后使用maven打包到本地仓库，并且添加到Client和Server的pom依赖中，这样就实现了二者接口的一致性。其中maven打包工具为点击install按钮：

![maven-install.png](https://pic.tyzhang.top/images/2020/07/09/maven-install.png)

然后就会在本地仓库中生成对应的API jar包，添加到依赖以后客户端和服务器端就都能调用。

```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>ServiceApi</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

# 测试方法

在App包下的都是都是启动方法，首先需要启动Server端的方法，然后启动Client端的方法，对应的方法启动一致即可，总共包含了三种Dubbo启动方法。