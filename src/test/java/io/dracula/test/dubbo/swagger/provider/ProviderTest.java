package io.dracula.test.dubbo.swagger.provider;

import io.dracula.test.dubbo.swagger.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderMain.class)
public class ProviderTest {

    private static Logger logger = LoggerFactory.getLogger(ProviderTest.class);

    @Autowired
    private TestService testService;

    @Test
    public void testLookup(){
        System.out.println(testService.getTestService());
    }

    @Test
    public void testCache(){
        logger.info("第一回调用");
        testService.sayHello(null);
        logger.info("第二回调用");
        testService.sayHello(null);
    }

}
