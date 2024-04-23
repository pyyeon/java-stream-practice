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

class K_makeElementDoubleTest {
    K_makeElementDouble solution = spy(K_makeElementDouble.class);

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
        String path = "src/main/java/com/choongang/K_makeElementDouble.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("[1, 2, 3, 4, 5]의 요소를 가진 List를 입력받은 경우, [2, 4, 6, 8, 10] List를 리턴해야 합니다")
    public void test_1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(solution.makeElementDouble(list)).isEqualTo(Arrays.asList(2, 4, 6, 8, 10));
    }

    @Test
    @DisplayName("[0, 3, 5, 8]의 요소를 가진 List를 입력받은 경우, [0, 6, 10, 16] List를 리턴해야 합니다")
    public void test_2() {
        List<Integer> list = Arrays.asList(0, 3, 5, 8);
        assertThat(solution.makeElementDouble(list)).isEqualTo(Arrays.asList(0, 6, 10, 16));
    }

    @Test
    @DisplayName("[]와 같이 비어있는 List를 입력받은 경우, [] List를 리턴해야 합니다")
    public void test_3() {
        List<Integer> list = Arrays.asList();
        assertThat(solution.makeElementDouble(list)).isEqualTo(Arrays.asList());
    }

    @Test
    @DisplayName("[2, -9, -10, -15]의 요소를 가진 List를 입력받은 경우, [-4, -18, -20, -30] List를 리턴해야 합니다")
    public void test_4() {
        List<Integer> list = Arrays.asList(-2, -9, -10, -15);
        assertThat(solution.makeElementDouble(list)).isEqualTo(Arrays.asList(-4, -18, -20, -30));
    }

}