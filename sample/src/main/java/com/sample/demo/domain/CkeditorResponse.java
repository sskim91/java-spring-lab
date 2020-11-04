package com.sample.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sskim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CkeditorResponse {

    private String uploaded;
    private String fileName;
    private String url;
}
