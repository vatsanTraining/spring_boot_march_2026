One Bean By Id => defulat it looks for bean with id as the instance variable bean, if found it is injected


One Bean By Type  => that bean gets injected

No Bean  => throws exception 


More than One Bean By Type  excetion is thrown and we have to do a proper configuration


More than one Bean By Type - use @Primary bean with@Primary will be injected

More than one Bean By Type - @Qualifier at the place where injection happends and pass the id of the bean to @Qualifier

More than one Bean By Type - @Profile add the annotation on the Bean which has to be injected and run application in that profile

Mone than one Bean By Type - add a property in application.properties file and use 
                                               @ConditionalOnProperty(havingValue = "set",name = "store.mode")

    


