package com.choongang;
import java.util.*;
import java.util.stream.*;

public class J_mergeTwoStream {
    public List<String> mergeTwoStream(List<String> list1, List<String> list2) {
        // TODO:String 타입을 요소로 가지는 List 두 개를 입력받아,
        //  스트림을 이용해 하나의 List로 합친 결과를 리턴해야 합니다.

        return Stream.concat(list1.stream(),list2.stream()) //concat으로 합치는건 stream만 들어 올 수 있음
                .collect(Collectors.toList()); //Stream. 스트림 클래스 가져옴.


    }
}
