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