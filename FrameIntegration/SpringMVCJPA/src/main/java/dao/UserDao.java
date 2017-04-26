package dao;

import entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yuyufeng on 2017/4/20.
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

}
