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

class G_filterNameTest {
    G_filterName solution = spy(G_filterName.class);

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
        String path = "src/main/java/com/choongang/G_filterName.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("[\"김코딩\", \"박해커\", \"김코딩\", \"최자바\", \"김자바\"]의 요소를 가진 List를 입력받은 경우, String 타입을 요소로 가지는 배열 {\"김자바\", \"김코딩\"}을 리턴해야 합니다.")
    public void test_1() {
        List<String> names = Arrays.asList("김코딩", "박해커", "김코딩", "최자바", "김자바");
        assertThat(solution.filterName(names)).isEqualTo(new String[]{"김자바", "김코딩"});
    }

    @Test
    @DisplayName("[\"김코딩\", \"김해커\", \"김자바\", \"김코드\", \"김코츠\"]의 요소를 가진 List를 입력받은 경우, String 타입을 요소로 가지는 배열 {\"김자바\", \"김코드\", \"김코딩\", \"김코츠\", \"김해커\"}을 리턴해야 합니다.")
    public void test_2() {
        List<String> names = Arrays.asList("김코딩", "김해커", "김자바", "김코드", "김코츠");
        assertThat(solution.filterName(names)).isEqualTo(new String[]{"김자바", "김코드", "김코딩", "김코츠", "김해커"});
    }

    @Test
    @DisplayName("[\"코딩김\", \"해커박\", \"코드김\", \"자바최\"]의 요소를 가진 List를 입력받은 경우, 빈 배열을 리턴해야 합니다")
    public void test_3() {
        List<String> names = Arrays.asList("코딩김", "해커박", "코드김", "자바최");
        assertThat(solution.filterName(names)).isEqualTo(new String[]{});
    }

    @Test
    @DisplayName("[]와 같이 비어있는 List를 입력받은 경우, 빈 배열을 리턴해야 합니다")
    public void test_4() {
        List<String> names = Arrays.asList();
        assertThat(solution.filterName(names)).isEqualTo(new String[]{});
    }

}