package io.dracula.test.dubbo.swagger.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderMain.class)
public class LookupTest {

    @Autowired
    private TestServiceImpl testServiceImpl;

    @Test
    public void test(){
        System.out.println(testServiceImpl.getTestService());
    }

}
