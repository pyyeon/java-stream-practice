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

class I_findLongestLengthTest {
    I_findLongestLength solution = spy(I_findLongestLength.class);

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
        String path = "src/main/java/com/choongang/I_findLongestLength.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("{\"codecodcod\", \"java\", \"backend\", \"programming\"}의 요소를 가진 String 타입을 요소로 가지는 배열을 입력받은 경우, 11을 리턴해야 합니다")
    public void test_1() {
        String[] strArr = {"codecodcod", "java", "backend", "programming"};
        assertThat(solution.findLongestLength(strArr)).isEqualTo(11);
    }

    @Test
    @DisplayName("{}와 같이 빈 배열을 입력받은 경우, 0을 리턴해야 합니다")
    public void test_2() {
        String[] strArr = {};
        assertThat(solution.findLongestLength(strArr)).isEqualTo(0);
    }

    @Test
    @DisplayName("{\"a\", \"b\", \"c\", \"d\", \"e\"}의 요소를 가진 String 타입을 요소로 가지는 배열을 입력받은 경우, 1을 리턴해야 합니다")
    public void test_3() {
        String[] strArr = {"a", "b", "c", "d", "e"};
        assertThat(solution.findLongestLength(strArr)).isEqualTo(1);
    }

    @Test
    @DisplayName("{\"coding\", \"is\", \"exciting\", \"!\"}의 요소를 가진 String 타입을 요소로 가지는 배열을 입력받은 경우, 8을 리턴해야 합니다")
    public void test_4() {
        String[] strArr = {"coding", "is", "exciting", "!"};
        assertThat(solution.findLongestLength(strArr)).isEqualTo(8);
    }
}