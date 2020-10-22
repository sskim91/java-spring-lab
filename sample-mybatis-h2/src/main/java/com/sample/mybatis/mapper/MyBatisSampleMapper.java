package com.sample.mybatis.mapper;

import com.sample.mybatis.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

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
}
