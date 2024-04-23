package com.choongang;
import java.util.*;
import java.util.stream.*;

public class M_findPeople {
    public List<String> findPeople(List<String> male, List<String> female, String lastName) {
        // TODO:남성 회원 이름의 List와 여성 회원 이름의 List가 있습니다.
        //  남성 회원과 여성 회원 중 특정 성씨를 갖고 있는 사람의 명단이 필요합니다.
        //  중복된 이름은 제거하고 특정 성씨를 갖고 있는 회원들의 이름을 정렬한 후 List로 리턴해야 합니다.
        //
        //## **입력**
//        if (female.isEmpty() || male.isEmpty() || lastName.isEmpty()){
//
//                return new ArrayList<>();
//            }



        return Stream.concat(male.stream(),female.stream())
                .distinct()
                .filter(person -> person.startsWith(lastName))
                .sorted()
                .collect(Collectors.toList());

    }
}
