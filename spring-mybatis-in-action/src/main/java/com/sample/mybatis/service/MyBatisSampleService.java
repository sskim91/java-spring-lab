package com.sample.mybatis.service;

import com.sample.mybatis.domain.BoardVO;
import com.sample.mybatis.mapper.MyBatisSampleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sskim
 */
@Service
@RequiredArgsConstructor
public class MyBatisSampleService {

    private final MyBatisSampleMapper mapper;

    public String getTimeService() {
        return mapper.getTime();
    }

    public int getInt() {
        return mapper.getInt();
    }

    public int saveBoard(BoardVO boardVO) {
        return mapper.insertBoard(boardVO);
    }

    public List<BoardVO> findAllBoard() {
        return mapper.getBoardAll();
    }

    public BoardVO findBoardByBno(int bno) {
        return mapper.getBoardByBno(bno);
    }
}
