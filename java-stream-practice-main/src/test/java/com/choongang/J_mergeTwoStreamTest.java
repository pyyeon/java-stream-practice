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

class J_mergeTwoStreamTest {
    J_mergeTwoStream solution = spy(J_mergeTwoStream.class);

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
        String path = "src/main/java/com/choongang/J_mergeTwoStream.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("[\"김코딩\", \"박해커\"] 와 [\"최자바\", \"이스프링\"] 두 개의 List를 입력받는 경우, [\"김코딩\", \"박해커\", \"최자바\", \"이스프링\"] List를 리턴해야 합니다.")
    public void test_1() {
        List<String> list1 = Arrays.asList("김코딩", "박해커");
        List<String> list2 = Arrays.asList("최자바", "이스프링");
        assertThat(solution.mergeTwoStream(list1, list2)).isEqualTo(Arrays.asList("김코딩", "박해커", "최자바", "이스프링"));
    }

    @Test
    @DisplayName("[\"김코딩\", \"김코딩\", \"김코딩\"] 와 [\"김코딩\", \"이스프링\"] 두 개의 List를 입력받는 경우, [\"김코딩\", \"김코딩\", \"김코딩\", \"김코딩\", \"이스프링\"] List를 리턴해야 합니다.")
    public void test_2() {
        List<String> list1 = Arrays.asList("김코딩", "김코딩", "김코딩");
        List<String> list2 = Arrays.asList("김코딩", "이스프링");
        List<String> result = Arrays.asList("김코딩", "김코딩", "김코딩", "김코딩", "이스프링");
        assertThat(solution.mergeTwoStream(list1, list2)).isEqualTo(result);
    }

    @Test
    @DisplayName("[] 와 [] 처럼 두 개의 비어있는 List를 입력받는 경우, [] 비어있는 List를 리턴해야 합니다.")
    public void test_3() {
        List<String> list1 = Arrays.asList();
        List<String> list2 = Arrays.asList();
        assertThat(solution.mergeTwoStream(list1, list2)).isEqualTo(Arrays.asList());
    }

    @Test
    @DisplayName("[\"code\", \"spring\"] 와 [\"BackEnd\", \"course\"] 두 개의 List를 입력받는 경우, [\"code\", \"spring\", \"BackEnd\", \"course\"] 비어있는 List를 리턴해야 합니다.")
    public void test_4() {
        List<String> list1 = Arrays.asList("code", "spring");
        List<String> list2 = Arrays.asList("BackEnd", "course");
        assertThat(solution.mergeTwoStream(list1, list2)).isEqualTo(Arrays.asList("code", "spring", "BackEnd", "course"));
    }
}