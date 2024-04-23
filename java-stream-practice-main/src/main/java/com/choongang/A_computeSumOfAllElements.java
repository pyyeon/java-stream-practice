package com.choongang;

import java.util.*;

public class A_computeSumOfAllElements {
    public int computeSumOfAllElements(List<Integer> list) {
        // TODO:Integer 타입을 요소로 가지는 List를 입력받아 요소의 총 합을 리턴해야 합니다.
//mapToInt: 메서드 스트림을 IntStream으로 변환해주는 메서드
//IntStream을 제외한 모든 스트림에서 동일하게 제공
        int sum = list.stream()
                .mapToInt(num -> num)
                .sum(); //정수에서만 사용가능


        return sum;
    }
}
