spring boot启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件
-file:./config/
-file:./
-classpath:/config/
-classpath:/
以上是按照优先级从高到低的顺序，所有位置的文件都会被加载，高优先级配置内容会覆盖低优先级配置内容

Spring boot会从这四个位置全部加载主配置文件：互补配置

还可以通过Spring.config.location来改变默认的配置文件配置

项目打包后，我们可以使用命令行参数的形式，启动项目的时候来指定配置文件的新位置；指定配置文件和默认加载的这些配置文件共同起作用行程互补配置