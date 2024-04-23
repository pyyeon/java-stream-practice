package com.choongang;

import java.util.*;

public class L_isHot {
    public boolean isHot(int[] temperature) {
        // TODO:이번주의 최고 온도만을 모아놓은 List를 분석하여 이번주가 더웠는지 알아봅시다.
        //  최고 기온이 30도를 넘은 날이 3일 이상이면 true를, 그렇지 않다면 false를 리턴해야 합니다.
        if (temperature.length != 7) {
            return false;
        }
//        return Arrays.stream(temperature)
//                .filter(t -> t >= 30)
//                .count() >= 3; //>= 3전까지는 숫자. 최종연산이 >= 3 이냐
//
        long hotDays = Arrays.stream(temperature)
                .filter(t -> t >= 30)
                .count();
        return hotDays >= 3;

    }
}
