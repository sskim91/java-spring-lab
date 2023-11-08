package com.sample.mybatis.domain;

import com.sample.mybatis.enums.BoardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author sskim
 */
@Data
@Builder
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regdate;
    private BoardType btype;
}
