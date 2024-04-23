package com.choongang;
import java.util.*;
import java.util.stream.*;

public class C_filterOddNumbers {
    public List<Integer> filterOddNumbers(List<Integer> list) {
        // TODO:Integer 타입을 요소로 가지는 List를 입력받이 짝수 요소만 추출한 List를 리턴해야 합니다.
        return list.stream()
            .filter(element -> element % 2 == 0)
            .collect(Collectors.toList()); // 어떤 타입으로 반환할지 ()안에 넣음
        //collect에서 빈 리스트가 들어오면 빈 리스트로 반환 > 빈 리스트 처리 안 해도 됨.


    }
}
