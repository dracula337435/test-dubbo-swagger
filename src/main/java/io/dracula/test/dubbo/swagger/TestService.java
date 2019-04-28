package io.dracula.test.dubbo.swagger;

/**
 * @author dk
 */
public interface TestService {

    /**
     *
     * @param name
     * @return
     */
    String sayHello(String name);

    /**
     *
     * @return
     */
    TestService getTestService();

}
