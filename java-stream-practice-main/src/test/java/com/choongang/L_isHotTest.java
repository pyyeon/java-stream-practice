package com.choongang;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.spy;
import java.util.*;

class L_isHotTest {
    L_isHot solution = spy(L_isHot.class);

    private static String readLineByLineJava8(String filePath) {  // .java code to String
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath(); //절대 경로 찾기

        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(absolutePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    @Test
    @DisplayName("반복문(for, while)은 사용하지 말아야 합니다")
    public void 반복문_사용_체크() {
        String path = "src/main/java/com/choongang/L_isHot.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("이번주의 최고 온도를 모아놓은 배열 {25, 29, 30, 31, 26, 30, 33}를 입력받은 경우, true를 리턴해야 합니다")
    public void test_1() {
        int[] temperature = {25, 29, 30, 31, 26, 30, 33};
        assertThat(solution.isHot(temperature)).isTrue();
    }

    @Test
    @DisplayName("이번주의 최고 온도를 모아놓은 배열 {30, 30, 30, 29, 27, 26, 25}를 입력받은 경우, true를 리턴해야 합니다")
    public void test_2() {
        int[] temperature = {30, 30, 30, 29, 27, 26, 25};
        assertThat(solution.isHot(temperature)).isTrue();
    }

    @Test
    @DisplayName("이번주의 최고 온도를 모아놓은 배열 {27, 30, 30, 29, 27, 26, 25}를 입력받은 경우, false를 리턴해야 합니다")
    public void test_3() {
        int[] temperature = {27, 30, 30, 29, 27, 26, 25};
        assertThat(solution.isHot(temperature)).isFalse();
    }

    @Test
    @DisplayName("이번주의 최고 온도를 모아놓은 배열로 빈 배열 {}을 입력받은 경우, false를 리턴해야 합니다")
    public void test_4() {
        int[] temperature = {};
        assertThat(solution.isHot(temperature)).isFalse();
    }
}