package io.dracula.test.dubbo.swagger.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import io.dracula.test.dubbo.swagger.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dk
 */
@RunWith(SpringRunner.class)
public class ConsuemrTest {

    private static Logger logger = LoggerFactory.getLogger(ConsuemrTest.class);

    @Reference
    private TestService testService;

    @Test
    public void test(){
        System.out.println(testService.sayHello("gxk"));
    }

    /**
     * 默认，使用Config内部类来加载
     * @author dk
     */
    @Configuration
    @DubboComponentScan
    public static class Config{

        @Bean
        public ApplicationConfig applicationConfig(){
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("test-dubbo-swagger-consuemr");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig(){
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }

    }

}
