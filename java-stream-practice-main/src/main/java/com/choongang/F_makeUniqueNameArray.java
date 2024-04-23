package com.choongang;

import java.util.*;
import java.util.stream.Collectors;

public class F_makeUniqueNameArray {
    public String[] makeUniqueNameArray(List<String> names) {
        // TODO:String 타입을 요소로 가지는 List를 입력받아 중복을 제거하고
        //  정렬한 후 String 타입을 요소로 갖는 배열로 리턴해야 합니다.
//        if (names.isEmpty() || names == null){
//            return  null;
//        }

        return names.stream()
                .distinct()//알아서 중복제거
                .sorted() //정렬 (오름차순)
                .toArray(String[]::new);


    }
}
