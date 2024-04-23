package com.choongang;
import java.util.*;

public class I_findLongestLength {
    public int findLongestLength(String[] strArr) {
        // TODO:String 타입을 요소로 가지는 배열을 입력받아,
        //  가장 길이가 긴 문자열 요소의 길이를 리턴해야 합니다.
//        if (strArr.length == 0  ){
//            return 0;
//        }
        return Arrays.stream(strArr)
                .mapToInt(String::length)//map 각각의 요소 바꾸기
                //모든 요소를 구할때 :: 가능
                .max()
                .orElse(0); //요소가 문자열이기때문에 null방지 가능

    }
}
