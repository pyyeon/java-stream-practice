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

class D_computeCountOfFemaleMemberTest {
    D_computeCountOfFemaleMember solution = spy(D_computeCountOfFemaleMember.class);

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
        String path = "src/main/java/com/choongang/D_computeCountOfFemaleMember.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("성별이 Female인 회원의 수가 2명인 경우, 2를 리턴해야 합니다")
    public void test_1() {
        D_computeCountOfFemaleMember.Member coding = new D_computeCountOfFemaleMember.Member("coding", "Female");
        D_computeCountOfFemaleMember.Member hacker = new D_computeCountOfFemaleMember.Member("hacker", "Male");
        D_computeCountOfFemaleMember.Member java = new D_computeCountOfFemaleMember.Member("java", "Female");
        List<D_computeCountOfFemaleMember.Member> members = Arrays.asList(coding, hacker, java);
        assertThat(solution.computeCountOfFemaleMember(members)).isEqualTo(2);
    }

    @Test
    @DisplayName("성별이 Female인 회원의 수가 4명 인 경우, 4를 리턴해야 합니다")
    public void test_2() {
        D_computeCountOfFemaleMember.Member coding = new D_computeCountOfFemaleMember.Member("coding", "Female");
        D_computeCountOfFemaleMember.Member hacker = new D_computeCountOfFemaleMember.Member("hacker", "Male");
        D_computeCountOfFemaleMember.Member java = new D_computeCountOfFemaleMember.Member("java", "Female");
        D_computeCountOfFemaleMember.Member js = new D_computeCountOfFemaleMember.Member("js", "Female");
        D_computeCountOfFemaleMember.Member code = new D_computeCountOfFemaleMember.Member("code", "Female");
        List<D_computeCountOfFemaleMember.Member> members = Arrays.asList(coding, hacker, java, js, code);
        assertThat(solution.computeCountOfFemaleMember(members)).isEqualTo(4);
    }

    @Test
    @DisplayName("회원의 성별이 모두 남자인 경우, 0을 리턴해야 합니다")
    public void test_3() {
        D_computeCountOfFemaleMember.Member coding = new D_computeCountOfFemaleMember.Member("coding", "Male");
        D_computeCountOfFemaleMember.Member hacker = new D_computeCountOfFemaleMember.Member("hacker", "Male");
        D_computeCountOfFemaleMember.Member java = new D_computeCountOfFemaleMember.Member("java", "Male");
        List<D_computeCountOfFemaleMember.Member> members = Arrays.asList(coding, hacker, java);
        assertThat(solution.computeCountOfFemaleMember(members)).isEqualTo(0);
    }

    @Test
    @DisplayName("회원의 수가 0명인 경우, 0을 리턴해야 합니다")
    public void test_4() {
        List<D_computeCountOfFemaleMember.Member> members = Arrays.asList();
        assertThat(solution.computeCountOfFemaleMember(members)).isEqualTo(0);
    }
}