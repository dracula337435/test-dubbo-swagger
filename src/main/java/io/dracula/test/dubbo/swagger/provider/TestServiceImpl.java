package io.dracula.test.dubbo.swagger.provider;

import com.alibaba.dubbo.config.annotation.Service;
import io.dracula.test.dubbo.swagger.TestService;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * @author dk
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }

    @Lookup
    public TestServiceImpl getTestService(){
        return null;
    }

}
