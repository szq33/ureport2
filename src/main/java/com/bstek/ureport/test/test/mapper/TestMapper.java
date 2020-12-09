package com.bstek.ureport.test.test.mapper;


import com.bstek.ureport.test.test.bean.User;
import com.bstek.ureport.test.test.bean.UserMan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {


    /**
     * 报表测试查询用户
     * @param isDeleted
     * @return
     */
    @Select("select id as userId,name as userName from blade_user where is_deleted=#{isDeleted}")
    List<UserMan> findName(@Param("isDeleted") Integer isDeleted);
}
