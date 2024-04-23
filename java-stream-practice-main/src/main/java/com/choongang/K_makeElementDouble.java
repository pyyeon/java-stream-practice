package com.choongang;
import java.util.*;
import java.util.stream.*;

public class K_makeElementDouble {
    public List<Integer> makeElementDouble(List<Integer> list) {
        // TODO:Integer 타입을 요소로 가지는 List를 입력받아
        //  각 요소에 2를 곱한 새로운 List를 리턴해야 합니다.
//        if (list.isEmpty()){
//            return  new ArrayList<>();
//        }

        return list.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList()); //빈 리스트일때 빈 리스트로 반환
    }
}
