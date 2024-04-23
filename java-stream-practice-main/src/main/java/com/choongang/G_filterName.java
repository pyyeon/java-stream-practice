package com.choongang;

import java.util.*;

public class G_filterName {
    public String[] filterName(List<String> names) {
        // TODO:String타입을 요소로 가지는 List를 입력받아 중복을 제거하고
        //  김씨 성을 가진 이름들을 정렬하여 문자열 배열로 리턴해야 합니다.
        if (names == null || names.isEmpty()) {
            return new String[0];
        }
        return names.stream() //list -> stream
                .distinct()
                .filter(str -> str.startsWith("김"))// java11부터 사용가능
//                .filter(str -> str.charAt(0) == '김') //도 가능 (java 11 이전)
                .sorted()
                .toArray(String[]::new);


    }

}
