package io.dracula.test.dubbo.swagger.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dk
 */
@RestController
public class FakeController {

    /**
     *
     * @return
     */
    @GetMapping("/swagger-resources/configuration/security")
    public SecurityConfiguration securityConfiguration(){
        return new SecurityConfiguration(null, null, null, null, null, null, null, null);
    }

    /**
     *
     * @return
     */
    @GetMapping("/swagger-resources/configuration/ui")
    public UiConfiguration uiConfiguration(){
        UiConfiguration uiConfiguration = new UiConfiguration(
                true,
                false,
                1,
                1,
                ModelRendering.of("example"),
                false,
                DocExpansion.of("none"),
                false,
                null,
                OperationsSorter.of("alpha"),
                false,
                TagsSorter.of("alpha"),
                "");
        return uiConfiguration;
    }

    /**
     *
     * @return
     */
    @GetMapping("/swagger-resources")
    public List<SwaggerResource> swaggerResources(){
        SwaggerResource resource = new SwaggerResource();
        resource.setName("for dubbo");
        resource.setSwaggerVersion("2.0");
        resource.setUrl("/v2/api-docs");
        List<SwaggerResource> list = new LinkedList<>();
        list.add(resource);
        return list;
    }

}
