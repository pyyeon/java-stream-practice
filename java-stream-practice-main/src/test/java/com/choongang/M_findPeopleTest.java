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

class M_findPeopleTest {
    M_findPeople solution = spy(M_findPeople.class);

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
        String path = "src/main/java/com/choongang/M_findPeople.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("남성 회원 List [\"김코딩\", \"최자바\", \"김코츠\"]와 여성 회원 List [\"박해커\", \"김유클\", \"김코딩\"], \"김\"씨 성을 입력받은 경우, List [\"김유클\", \"김코딩\", \"김코츠\"]를 리턴해야 합니다")
    public void test_1() {
        List<String> male = Arrays.asList("김코딩", "최자바", "김코츠");
        List<String> female = Arrays.asList("박해커", "김유클", "김코딩");
        assertThat(solution.findPeople(male, female, "김")).isEqualTo(Arrays.asList("김유클", "김코딩", "김코츠"));
    }

    @Test
    @DisplayName("남성 회원 List [\"김코딩\", \"최자바\", \"김코츠\"]와 여성 회원 List [\"박해커\", \"김유클\", \"김코딩\"], \"최\"씨 성을 입력받은 경우, List [\"김유클\", \"최자바\"]를 리턴해야 합니다")
    public void test_2() {
        List<String> male = Arrays.asList("김코딩", "최자바", "김코츠");
        List<String> female = Arrays.asList("박해커", "김유클", "김코딩");
        assertThat(solution.findPeople(male, female, "최")).isEqualTo(Arrays.asList("최자바"));
    }

    @Test
    @DisplayName("남성 회원 List [\"김코드\", \"최자바\", \"이스프링\"]와 여성 회원 List [\"박해커\", \"김유클\", \"김코딩\"], \"정\"씨 성을 입력받은 경우, 비어있는 List []를 리턴해야 합니다")
    public void test_3() {
        List<String> male = Arrays.asList("김코드", "최자바", "이스프링");
        List<String> female = Arrays.asList("박해커", "김유클", "김코딩");
        assertThat(solution.findPeople(male, female, "정")).isEqualTo(Arrays.asList());
    }

    @Test
    @DisplayName("비어있는 남성 회원 List []와 비어있는 여성 회원 List [], \"김\"씨 성을 입력받은 경우, 비어있는 List []를 리턴해야 합니다")
    public void test_4() {
        List<String> male = Arrays.asList();
        List<String> female = Arrays.asList();
        assertThat(solution.findPeople(male, female, "김")).isEqualTo(Arrays.asList());
    }
}