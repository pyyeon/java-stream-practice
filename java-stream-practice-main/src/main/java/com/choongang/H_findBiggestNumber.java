package com.choongang;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class H_findBiggestNumber {
    public Integer findBiggestNumber(int[] arr) {
        // TODO:int 타입을 요소로 가지는 배열을 입력받아
        //  가장 큰 요소를 리턴해야 합니다.
        if (arr.length == 0) {
            return null;
        }//비어있을때를 빼줘서 스트림 생성조차 하지 않음
        return Arrays.stream(arr)
                .max()
                .getAsInt(); //정수이기 때문에 orElse(null피하기위한 메소드) 못씀


    }
}
