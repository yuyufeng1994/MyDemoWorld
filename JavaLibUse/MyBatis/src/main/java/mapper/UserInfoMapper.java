package mapper;

import entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yuyufeng on 2017/6/5.
 */
public interface UserInfoMapper {
    List<UserInfo> selectList();

    int add(@Param("user") UserInfo user);
}
