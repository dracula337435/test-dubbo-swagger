# 试验dubbo

dubbo-swagger

```@EnableSwagger2```先看一下几个关键端点  
```/swagger-resources/configuration/ui```
```
{
deepLinking: true,
displayOperationId: false,
defaultModelsExpandDepth: 1,
defaultModelExpandDepth: 1,
defaultModelRendering: "example",
displayRequestDuration: false,
docExpansion: "none",
filter: false,
operationsSorter: "alpha",
showExtensions: false,
tagsSorter: "alpha",
validatorUrl: "",
apisSorter: "alpha",
jsonEditor: false,
showRequestHeaders: false,
supportedSubmitMethods: [
"get",
"put",
"post",
"delete",
"options",
"head",
"patch",
"trace"
]
}
```
```/swagger-resources/configuration/security```
```
{ }
```
```/swagger-resources```
```
[
{
name: "default",
url: "/v2/api-docs",
swaggerVersion: "2.0",
location: "/v2/api-docs"
}
]
```
参考```springfox.documentation.swagger.web.ApiResourceController```，写一套假的，同样暴露如上端点，见```io.dracula.test.dubbo.swagger.provider.FakeController```

另，似乎可以控制页面上的base-url
http://localhost:8080/swagger-ui.html?baseUrl=%2Fswagger-dubbo%2Fapi-docs

一个问题：  
当有了动态代理，例如```TestServiceImpl```中的```@Cacheable```，```dubbo-swagger```报错，如
```
{
  "timestamp": "2019-05-14T13:44:47.213+0000",
  "status": 500,
  "error": "Internal Server Error",
  "message": "wrong number of arguments",
  "path": "/h/io.dracula.test.dubbo.swagger.TestService/sayHello"
}
```
可定位问题在```DubboHttpController```的```invokeDubbo```方法，其中使用了```NameDiscover```  
用多种方法尝试得到参数名，其中可见
```
static {
    parameterNameDiscover = new PrioritizedParameterNameDiscoverer();
    ((PrioritizedParameterNameDiscoverer) parameterNameDiscover)
            .addDiscoverer(new LocalVariableTableParameterNameDiscoverer());
    ((PrioritizedParameterNameDiscoverer) parameterNameDiscover)
            .addDiscoverer(new StandardReflectionParameterNameDiscoverer());
}
```
正常来说可从```LocalVariableTableParameterNameDiscoverer```得到，但是其需要根据类型得到```.class```文件。见```inspectClass```方法中  
```
InputStream is = clazz.getResourceAsStream(ClassUtils.getClassFileName(clazz));
if (is == null) {
    // 略
}
```
有动态代理（aop等）的情况下，找不到```.class```文件，因为此时```Class```名类似于```io.dracula.test.dubbo.swagger.provider.TestServiceImpl$$EnhancerBySpringCGLIB$$5a39626@592ca48c```，无法在```classpath```下找到