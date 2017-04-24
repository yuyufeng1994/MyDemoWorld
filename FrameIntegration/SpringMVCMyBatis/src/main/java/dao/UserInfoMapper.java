package dao;

import entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {


    List<UserInfo> selectList();

    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}