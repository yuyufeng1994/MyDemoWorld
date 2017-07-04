package mapper;

import entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yuyufeng on 2017/6/5.
 * Mybatis的一级缓存是指SqlSession。一级缓存的作用域是一个SqlSession。Mybatis默认开启一级缓存。
 * 在同一个SqlSession中，执行相同的查询SQL，第一次会去查询数据库，并写到缓存中；第二次直接从缓存中取。当执行SQL时两次查询中间发生了增删改操作，则SqlSession的缓存清空。
 * Mybatis的二级缓存是指mapper映射文件。二级缓存的作用域是同一个namespace下的mapper映射文件内容，多个SqlSession共享。Mybatis需要手动设置启动二级缓存。
 * 在同一个namespace下的mapper文件中，执行相同的查询SQL，第一次会去查询数据库，并写到缓存中；第二次直接从缓存中取。当执行SQL时两次查询中间发生了增删改操作，则二级缓存清空。
 */
public interface UserInfoMapper {
    List<UserInfo> selectList();

    int add(@Param("user") UserInfo user);

    UserInfo selectOne(@Param("userId") Long userId);
}
