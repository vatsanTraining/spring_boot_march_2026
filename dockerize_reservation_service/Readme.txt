One Bean By Id  => Runs normally

One Bean By Type  => Runs normally

More than One Bean By Type  => Exception is thrown

No Bean   = Exception is thrown

More than one Bean By Type - Bean with @Primary will be injected

More than one Bean By Type - @Qualifier add the id of the Bean as the argument to @Qualifier

More than one Bean By Type - @Profile annotation injects only the bean with that specific profile where the application running

Mone than one Bean By Type - @ConditionalOnProperty(name = "storage.option",havingValue = "list")
 which ever property defined in application.properties file that bean will be created and injected
    


