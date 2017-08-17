package demo.java.net.rpc.test;


import demo.java.net.rpc.HelloService;
import demo.java.net.rpc.HelloServiceImpl;
import demo.java.net.rpc.Server;
import demo.java.net.rpc.ServiceCenter;

import java.io.IOException;

/**
 * Created by yuyufeng on 2017/8/17.
 * 一、RPC简介
 * RPC，全称为Remote Procedure Call，即远程过程调用，它是一个计算机通信协议。它允许像调用本地服务一样调用远程服务。它可以有不同的实现方式。如RMI(远程方法调用)、Hessian、Http invoker等。另外，RPC是与语言无关的。
 * <p>
 * RPC示意图
 * <p>
 * <p>
 * 如上图所示，假设Computer1在调用sayHi()方法，对于Computer1而言调用sayHi()方法就像调用本地方法一样，调用 –>返回。但从后续调用可以看出Computer1调用的是Computer2中的sayHi()方法，RPC屏蔽了底层的实现细节，让调用者无需关注网络通信，数据传输等细节。
 * <p>
 * 二、RPC框架的实现
 * 上面介绍了RPC的核心原理：RPC能够让本地应用简单、高效地调用服务器中的过程（服务）。它主要应用在分布式系统。如Hadoop中的IPC组件。但怎样实现一个RPC框架呢？
 * <p>
 * 从下面几个方面思考，仅供参考：
 * <p>
 * 1.通信模型：假设通信的为A机器与B机器，A与B之间有通信模型，在Java中一般基于BIO或NIO；。
 * <p>
 * 2.过程（服务）定位：使用给定的通信方式，与确定IP与端口及方法名称确定具体的过程或方法；
 * <p>
 * 3.远程代理对象：本地调用的方法(服务)其实是远程方法的本地代理，因此可能需要一个远程代理对象，对于Java而言，远程代理对象可以使用Java的动态对象实现，封装了调用远程方法调用；
 * <p>
 * 4.序列化，将对象名称、方法名称、参数等对象信息进行网络传输需要转换成二进制传输，这里可能需要不同的序列化技术方案。如:protobuf，Arvo等。
 * <p>
 * 三、Java实现RPC框架
 * 1、实现技术方案
 * 下面使用比较原始的方案实现RPC框架，采用Socket通信、动态代理与反射与Java原生的序列化。
 * <p>
 * 2、RPC框架架构
 * RPC架构分为三部分：
 * <p>
 * 1）服务提供者，运行在服务器端，提供服务接口定义与服务实现类。
 * <p>
 * 2）服务中心，运行在服务器端，负责将本地服务发布成远程服务，管理远程服务，提供给服务消费者使用。
 * <p>
 * 3）服务消费者，运行在客户端，通过远程代理对象调用远程服务。
 * <p>
 * 3、 具体实现
 * 服务提供者接口定义与实现，代码如下：
 */
public class RPCServerTest {
    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
/**
 * 四、总结
 * RPC本质为消息处理模型，RPC屏蔽了底层不同主机间的通信细节，让进程调用远程的服务就像是本地的服务一样。
 * <p>
 * 五、可以改进的地方
 * 这里实现的简单RPC框架是使用Java语言开发，与Java语言高度耦合，并且通信方式采用的Socket是基于BIO实现的，IO效率不高，还有Java原生的序列化机制占内存太多，运行效率也不高。可以考虑从下面几种方法改进。
 * <p>
 * 可以采用基于JSON数据传输的RPC框架；
 * 可以使用NIO或直接使用Netty替代BIO实现；
 * 使用开源的序列化机制，如Hadoop Avro与Google protobuf等；
 * 服务注册可以使用Zookeeper进行管理，能够让应用更加稳定。
 */
