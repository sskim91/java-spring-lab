package com.sample.mybatis.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author sskim
 */
@Data
@Builder
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private Date regdate;
}
