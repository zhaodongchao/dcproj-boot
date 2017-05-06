package org.dongchao;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *  项目打成war包部署在其他java WEB 服务器中运行时，必须要添加此类，并重写configure方法！
 *  SpringBootServletInitializer 是一个支持Spring Boot的Spring  WebApplicationInitializer 实现。除了配置Spring的Dispatcher- Servlet ，
 *  SpringBootServletInitializer 还会在Spring应用程序上下文里查找 Filter 、Servlet 或 ServletContextInitializer 类型的Bean，把它们绑定到Servlet容器里。
 *
 *  DcporjStarterApplication 类上添加了 @SpringBootApplication 注解。这会隐性开启组件扫描，而组件扫描则会发现并应用其他配置类
 *
 *  Created by zhaodongchao on 2017/5/5.
 */
public class WebApplicationInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DcprojStarterApplication.class);
    }
}
