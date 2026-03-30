One Bean By Id  => Runs normally

One Bean By Type  => Runs normally

More than One Bean By Type  => Exception is thrown

No Bean   = Exception is thrown

More than one Bean By Type - Bean with @Primary will be injected

More than one Bean By Type - @Qualifier add the id of the Bean as the argument to @Qualifier

More than one Bean By Type - @Profile annotation injects only the bean with that specific profile where the application running

Mone than one Bean By Type - @ConditionalOnProperty(name = "storage.option",havingValue = "list")
 which ever property defined in application.properties file that bean will be created and injected
    
    
====================

Add Dockerfile to the project context path
Paste the entiries given in the same code
Invoke docker build -t spring-boot-app:latest .
Run docker run -p 8080:8080 spring-boot-app:latest
view the output

To push to dockler hub
docker login
docker tag spring-boot-app:latest <your-dockerhub-username>/spring-boot
-app:latest
docker push <your-dockerhub-username>/spring-boot-app:latest


