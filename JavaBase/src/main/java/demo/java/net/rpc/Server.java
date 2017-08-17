package demo.java.net.rpc;

import java.io.IOException;

/**
 * Created by yuyufeng on 2017/8/17.
 */
public interface Server {
    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}