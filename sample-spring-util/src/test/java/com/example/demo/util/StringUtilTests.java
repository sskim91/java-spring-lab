package com.example.demo.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import static org.assertj.core.api.Assertions.*;

public class StringUtilTests {

    @Test
    @DisplayName("hasLength 테스트")
    void hasLengthTest() throws Exception{
        assertThat(StringUtils.hasLength(null)).isFalse();
        assertThat(StringUtils.hasLength("")).isFalse();
        assertThat(StringUtils.hasLength(" ")).isTrue();
        assertThat(StringUtils.hasLength("Hello")).isTrue();
    }

    @Test
    @DisplayName("hasText 테스트")
    void hasTextTest() throws Exception{
        assertThat(StringUtils.hasText(null)).isFalse();
        assertThat(StringUtils.hasText("")).isFalse();
        assertThat(StringUtils.hasText(" ")).isFalse();
        assertThat(StringUtils.hasText("12345")).isTrue();
        assertThat(StringUtils.hasText(" 12345 ")).isTrue();
    }

    @Test
    @DisplayName("containsWhitespace 테스트")
    void containsWhitespaceTest() throws Exception{
        assertThat(StringUtils.containsWhitespace(" ")).isTrue();
        assertThat(StringUtils.containsWhitespace("")).isFalse();
        assertThat(StringUtils.containsWhitespace("123456")).isFalse();
        assertThat(StringUtils.containsWhitespace("123  456")).isTrue();
    }

    @Test
    @DisplayName("trimWhitespace 테스트")
    void trimWhitespaceTest() throws Exception{
        assertThat(StringUtils.trimWhitespace("   1234")).isEqualTo("1234");
        assertThat(StringUtils.trimWhitespace("   1234안녕     ")).isEqualTo("1234안녕");
        assertThat(StringUtils.trimWhitespace("   1234안녕 하세요")).isEqualTo("1234안녕 하세요");
    }

    @Test
    @DisplayName("trimAllWhitespace 테스트")
    void trimAllWhitespaceTest() throws Exception{
        assertThat(StringUtils.trimAllWhitespace("    1234    ")).isEqualTo("1234");
        assertThat(StringUtils.trimAllWhitespace("     1234안녕  하세요   ")).isEqualTo("1234안녕하세요");
    }

    @Test
    @DisplayName("trimLeadingCharacter 테스트")
    void trimLeadingCharacterTest() throws Exception{
        assertThat(StringUtils.trimLeadingCharacter("-01012345678", '-')).isEqualTo("01012345678");
    }

    @Test
    @DisplayName("trimTrailingCharacter 테스트")
    void trimTrailingCharacterTest() throws Exception{
        assertThat(StringUtils.trimTrailingCharacter("01012345678-", '-')).isEqualTo("01012345678");
    }
}
