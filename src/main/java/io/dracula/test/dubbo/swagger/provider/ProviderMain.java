package io.dracula.test.dubbo.swagger.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author dk
 */
@SpringBootApplication
@DubboComponentScan
@EnableCaching
public class ProviderMain {

    public static void main(String[] args){
        SpringApplication.run(ProviderMain.class, args);
    }

}
