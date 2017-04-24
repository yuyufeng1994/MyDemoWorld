package service;

import entity.UserInfo;

import java.util.List;

/**
 * Created by yuyufeng on 2017/1/4.
 */
public interface UserService {
    List<UserInfo> getUserPage(int pageNo, int pageSize);
}
