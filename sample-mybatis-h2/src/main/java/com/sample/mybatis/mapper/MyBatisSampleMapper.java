package com.sample.mybatis.mapper;

import com.sample.mybatis.domain.BoardVO;
import com.sample.mybatis.domain.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sskim
 */
@Mapper
public interface MyBatisSampleMapper {

    String getTime();

    int getInt();

    int insertBoard(BoardVO boardVO);

    List<BoardVO> getBoardAll();

    BoardVO getBoardByBno(int bno);

    @Insert("insert into user_tbl(type, name) values (#{type}, #{name})")
    int insertUser(UserVO userVO);

    @Select("select * from user_tbl")
    List<UserVO> getAllUser();
}
