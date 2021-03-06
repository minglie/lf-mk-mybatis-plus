package com.lf.mp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lf.mp.entity.User;
import com.lf.mp.vo.MutilTestVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Mr huangye
 * @createTime : 2020/7/9 11:30
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    List<User> selectAll2(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select("select * from user ${ew.customSqlSegment}")
    IPage<User> selectUsersPages(Page<User> userPage, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select("select id as userId,manager_id as userIds from user ")
    IPage<MutilTestVo> selectUsersPagesTest(Page<User> userPage);

    @Select("select t.id as userId,g.id as userIds from `user` t ,users g where t.name=g.name ")
    IPage<MutilTestVo> selectUsersPagesTest2(Page<User> userPage);

    @Select("select t.id as userId,g.id as userIds from `user` t ,users g where t.name=g.name and t.id =#{s}")
    IPage<MutilTestVo> selectUsersPagesTest3(Page<User> userPage,@Param("s") String s);

}
