package com.sample.mybatis.service;

import com.sample.mybatis.domain.BoardVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sskim
 */
@SpringBootTest
public class myBatisServiceTest {

    @Autowired
    MyBatisSampleService service;

    @Test
    @DisplayName("간단한 시간 가져오기 getTime()")
    void getTimeTest() {
        System.out.println("Time: " + service.getTimeService());
    }

    @Test
    @DisplayName("returnType 정수형")
    void getIntTest() {
        int integer = service.getInt();
        assertThat(integer).isEqualTo(2);
    }

    @Test
    @DisplayName("BOARD_TBL 저장 테스트")
    void saveBoardTest() {
        BoardVO boardVO = BoardVO.builder()
                .title("제목테스트")
                .content("내용테스트")
                .regdate(new Date())
                .build();

        int saveResult = service.saveBoard(boardVO);
        assertThat(saveResult).isEqualTo(1);
    }

    @Test
    @DisplayName("board_tbl 전체 가져오기")
    void findAllBoardTest() {
        List<BoardVO> allBoard = service.findAllBoard();
        for (BoardVO boardVO : allBoard) {
            System.out.println(allBoard);
        }
    }

    @Test
    @DisplayName("board_tbl 특정 게시물 가져오기")
    void findByBnoTest() {
        BoardVO boardByBno = service.findBoardByBno(1);
        assertThat(boardByBno.getTitle()).isEqualTo("제목");
    }
}
