package dev.mempoi.app;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUsers();

    User findById(Long id);

    List<User> findByAgeGreaterThan(int age);
}
