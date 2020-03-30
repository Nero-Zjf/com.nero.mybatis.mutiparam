package com.nero.mybatis.mutiparam.mapper;

import com.nero.mybatis.mutiparam.po.UserPO;
import com.nero.mybatis.mutiparam.pojo.UserParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<UserPO> getUserByNameSex1(String name, String sex);
    List<UserPO> getUserByNameSex2(Map<String,Object> map);
    List<UserPO> getUserByNameSex3(UserParam param);
    List<UserPO> getUserByNameSex4(@Param("name") String name, @Param("sex") String sex);

}
