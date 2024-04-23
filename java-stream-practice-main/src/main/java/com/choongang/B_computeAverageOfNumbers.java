package com.choongang;
import java.util.*;

public class B_computeAverageOfNumbers {
    public double computeAverageOfNumbers(List<Integer> list) {
        // TODO:Integer 타입을 요소로 가지는 List를 입력받아 요소의 평균을 리턴해야합니다.
      return list.stream()
                .mapToDouble(num -> num)
              //double타입으로 바꿔줌
                .average()
               .orElse(0.0); //null 이 아니면 아닌 값(0.0)을 반환해.



    }
}
