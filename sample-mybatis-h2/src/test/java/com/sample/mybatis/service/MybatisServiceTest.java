package com.sample.mybatis.service;

import com.sample.mybatis.domain.BoardVO;
import com.sample.mybatis.enums.BoardType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sskim
 */
@SpringBootTest
public class MybatisServiceTest {

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
                .title("제목")
                .content("내용")
                .regdate(LocalDateTime.now())
                .build();

        int saveResult = service.saveBoard(boardVO);
        assertThat(saveResult).isEqualTo(1);
    }

    @Test
    @DisplayName("BOARD_TBL ENUM 저장 테스트")
    void saveBoardWithEnumType() {
        BoardVO boardVO = BoardVO.builder()
                .title("제목")
                .content("내용")
                .regdate(LocalDateTime.now())
                .btype(BoardType.FAQ)
                .build();

        System.out.println(BoardType.FREE.getViewName());
        int saveResult = service.saveBoard(boardVO);
        assertThat(saveResult).isEqualTo(1);
    }

    @Test
    @DisplayName("board_tbl 전체 가져오기")
    void findAllBoardTest() {
        List<BoardVO> allBoard = service.findAllBoard();
        for (BoardVO boardVO : allBoard) {
            System.out.println("boardVO = " + boardVO);
        }
    }

    @Test
    @DisplayName("board_tbl 특정 게시물 가져오기")
    void findByBnoTest() {
        BoardVO boardByBno = service.findBoardByBno(1);
        assertThat(boardByBno.getTitle()).isEqualTo("제목");
    }
}
