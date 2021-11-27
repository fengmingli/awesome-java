Dubbo 并未使用 Java SPI，而是重新实现了一套功能更强的 SPI 机制。Dubbo SPI 的相关逻辑被封装在了 ExtensionLoader 类中，通过 ExtensionLoader，我们可以加载指定的实现类。Dubbo SPI 所需的配置文件需放置在 META-INF/dubbo 路径下，配置内容如下。

optimusPrime = org.apache.spi.OptimusPrime\
bumblebee = org.apache.spi.Bumblebee

与 Java SPI 实现类配置不同，
Dubbo SPI 是通过键值对的方式进行配置，这样我们可以按需加载指定的实现类。
另外，在测试 Dubbo SPI 时，需要在 Robot 接口上标注 @SPI 注解。


首先通过org.apache.dubbo.common.extension.ExtensionLoader.getExtensionLoader方法获取一个 ExtensionLoader 实例，然后再通过 ExtensionLoader 的 getExtension 方法获取拓展类对象。
这其中，getExtensionLoader 方法用于从缓存中获取与拓展类对应的 ExtensionLoader，若缓存未命中，则创建一个新的实例。该方法的逻辑比较简单，本章就不进行分析了。下面我们从 ExtensionLoader 的 getExtension 方法作为入口，对拓展类对象的获取过程进行详细的分析。