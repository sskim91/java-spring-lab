package com.example.pagehelper.mapper;

import com.example.pagehelper.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sskim
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();
}
