package service;

import entity.User;
import org.springframework.data.domain.Page;

/**
 * Created by yuyufeng on 2017/4/22.
 */
public interface UserService {
    Page<User>  findPage();
}
