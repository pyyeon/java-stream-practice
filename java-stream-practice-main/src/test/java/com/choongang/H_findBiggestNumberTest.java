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

class H_findBiggestNumberTest {
    H_findBiggestNumber solution = spy(H_findBiggestNumber.class);

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
        String path = "src/main/java/com/choongang/H_findBiggestNumber.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("{1, 10, 5, 32, 5}의 요소를 가진 배열을 입력받은 경우, 32를 리턴해야 합니다")
    public void test_1() {
        int[] arr = {1, 10, 5, 32, 5};
        assertThat(solution.findBiggestNumber(arr)).isEqualTo(32);
    }

    @Test
    @DisplayName("{1, 0, -2, -19, 3, -20}의 요소를 가진 배열을 입력받은 경우, 3을 리턴해야 합니다")
    public void test_2() {
        int[] arr = {1, 0, -2, -19, 3, -20};
        assertThat(solution.findBiggestNumber(arr)).isEqualTo(3);
    }

    @Test
    @DisplayName("{}와 같이 빈 배열을 입력받은 경우, null을 리턴해야 합니다")
    public void test_3() {
        int[] arr = {};
        assertThat(solution.findBiggestNumber(arr)).isNull();
    }

    @Test
    @DisplayName("{-10, -8, -2, -6, -3}의 요소를 가진 배열을 입력받은 경우, -2을 리턴해야 합니다")
    public void test_4() {
        int[] arr = {-10, -8, -2, -6, -3};
        assertThat(solution.findBiggestNumber(arr)).isEqualTo(-2);
    }
}