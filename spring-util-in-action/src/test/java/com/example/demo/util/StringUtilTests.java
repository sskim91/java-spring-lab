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

    @Test
    @DisplayName("matchesCharacter 테스트")
    void matchesCharacterTest() throws Exception{
        assertThat(StringUtils.matchesCharacter("sskim", 's')).isFalse();
    }

    @Test
    @DisplayName("startsWithIgnoreCase 테스트")
    void startsWithIgnoreCaseTest() throws Exception{
        assertThat(StringUtils.startsWithIgnoreCase("Hello, How are you", "HELLO")).isTrue();
        assertThat(StringUtils.startsWithIgnoreCase("Hello, How are you", "YOU")).isFalse();
    }

    @Test
    @DisplayName("endsWithIgnoreCase 테스트")
    void endsWithIgnoreCaseTest() throws Exception{
        assertThat(StringUtils.endsWithIgnoreCase("Hello, How are you", "YOU")).isTrue();
        assertThat(StringUtils.endsWithIgnoreCase("Hello, How are you", "HELLO")).isFalse();
    }

    @Test
    @DisplayName("countOccurrencesOf 테스트")
    void countOccurrencesOf() throws Exception{
        String str = "Hello, How are you? Fine Thank you h";
        assertThat(StringUtils.countOccurrencesOf(str, "H")).isEqualTo(2);
        assertThat(StringUtils.countOccurrencesOf(str, ",")).isEqualTo(1);
        assertThat(StringUtils.countOccurrencesOf(str, "y")).isEqualTo(2);
    }

    @Test
    @DisplayName("getFilename 테스트")
    void getFilenameTest() throws Exception{
        assertThat(StringUtils.getFilename("mypath/myfile.txt")).isEqualTo("myfile.txt");
    }

    @Test
    @DisplayName("getFilenameExtension 테스트")
    void getFilenameExtensionTest() throws Exception{
        assertThat(StringUtils.getFilenameExtension("mypath/myfile.txt")).isEqualTo("txt");
    }

    @Test
    @DisplayName("stripFilenameExtension 테스트")
    void stripFilenameExtensionTest() throws Exception{
        assertThat(StringUtils.stripFilenameExtension("mypath/myfile.txt")).isEqualTo("mypath/myfile");
    }
}
