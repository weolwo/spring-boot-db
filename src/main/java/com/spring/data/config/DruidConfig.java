package com.spring.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义数据源配置类
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.dataSource")//加载application.yml中的配置
    public DataSource druid() {

        DruidDataSource dataSource = new DruidDataSource();

        return dataSource;
    }

    //配置druid的监控,配置一个后台管理的servlet
    @Bean
    public ServletRegistrationBean stateViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置相关参数
        Map<String, String> initParams = new HashMap<>();

        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "");//默认就是允许所有访问
        initParams.put("deny", "192.168.20.128");

        bean.setInitParameters(initParams);
        return bean;
    }

    //配置一个web监控
    @Bean
    public FilterRegistrationBean webStateFilter() {

        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        //需要排除的
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
