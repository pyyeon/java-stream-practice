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

class E_computeAverageOfMaleMemberTest {
    E_computeAverageOfMaleMember solution = spy(E_computeAverageOfMaleMember.class);

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
        String path = "src/main/java/com/choongang/E_computeAverageOfMaleMember.java"; // 파일 위치
        String text = readLineByLineJava8(path);  //코드를 모두 java 파일로 변환
        assertThat(StringUtils.countMatches(text, "for")).isZero();
        assertThat(StringUtils.countMatches(text, "while")).isZero();
    }

    @Test
    @DisplayName("입력받은 두 명의 남자 회원의 나이가 [30, 32]세 라면, 31.0을 리턴해야 합니다")
    public void test_1() {
        E_computeAverageOfMaleMember.Member coding = new E_computeAverageOfMaleMember.Member("coding", "Female", 25);
        E_computeAverageOfMaleMember.Member hacker = new E_computeAverageOfMaleMember.Member("hacker", "Male", 30);
        E_computeAverageOfMaleMember.Member ingi = new E_computeAverageOfMaleMember.Member("ingi", "Male", 32);
        List<E_computeAverageOfMaleMember.Member> members = Arrays.asList(coding, hacker, ingi);
        assertThat(solution.computeAverageOfMaleMember(members)).isEqualTo(31.0);
    }

    @Test
    @DisplayName("입력받은 남자 회원의 나이가 [30, 32, 27, 50]세 라면, 34.75을 리턴해야 합니다")
    public void test_2() {
        E_computeAverageOfMaleMember.Member coding = new E_computeAverageOfMaleMember.Member("coding", "Male", 30);
        E_computeAverageOfMaleMember.Member hacker = new E_computeAverageOfMaleMember.Member("hacker", "Male", 32);
        E_computeAverageOfMaleMember.Member ingi = new E_computeAverageOfMaleMember.Member("ingi", "Male", 27);
        E_computeAverageOfMaleMember.Member code = new E_computeAverageOfMaleMember.Member("code", "Male", 50);
        List<E_computeAverageOfMaleMember.Member> members = Arrays.asList(coding, hacker, ingi, code);
        assertThat(solution.computeAverageOfMaleMember(members)).isEqualTo(34.75);
    }

    @Test
    @DisplayName("남자 회원이 없는 경우, 0을 리턴해야 합니다")
    public void test_3() {
        E_computeAverageOfMaleMember.Member coding = new E_computeAverageOfMaleMember.Member("coding", "Female", 30);
        E_computeAverageOfMaleMember.Member hacker = new E_computeAverageOfMaleMember.Member("hacker", "Female", 32);
        List<E_computeAverageOfMaleMember.Member> members = Arrays.asList(coding, hacker);
        assertThat(solution.computeAverageOfMaleMember(members)).isEqualTo(0);
    }

    @Test
    @DisplayName("회원의 수가 0인 경우, 0을 리턴해야 합니다")
    public void test_4() {
        List<E_computeAverageOfMaleMember.Member> members = Arrays.asList();
        assertThat(solution.computeAverageOfMaleMember(members)).isEqualTo(0);
    }
}