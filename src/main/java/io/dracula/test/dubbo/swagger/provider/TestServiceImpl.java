package io.dracula.test.dubbo.swagger.provider;

import com.alibaba.dubbo.config.annotation.Service;
import io.dracula.test.dubbo.swagger.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author dk
 */
@Service
public class TestServiceImpl implements TestService {

    private static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    @Cacheable(value = "some-cache")
    public String sayHello(String name) {
        String result = "hello "+name;
        logger.info("实际被调用了"+result);
        return result;
    }

    @Override
    @Lookup
    public TestService getTestService(){
        return null;
    }

}
