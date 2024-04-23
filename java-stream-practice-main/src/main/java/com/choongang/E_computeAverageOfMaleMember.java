package com.choongang;
import java.util.*;

public class E_computeAverageOfMaleMember {
    public double computeAverageOfMaleMember(List<Member> members) {
        // TODO:이번엔 `Member` 클래스를 이용해 회원의 이름, 성별, 나이까지 관리하려고 합니다.
        //  `Member` 타입을 요소로 가지는 List를 입력받아, 남성 회원들의 평균 나이를 리턴해야 합니다.
        //
        //## **입력**
//        if (members == null || members.isEmpty()){
//            return 0.0;
//        }

        return members.stream()
                .filter(member -> member.getGender().equals("Male"))
                .mapToDouble(Member::getAge)
                //스트림에서는 그냥 sum 안됨. map으로 바꾸고 해줘야함.
                .average()
                .orElse(0.0);// 여기서 orElse로 예외처리됨.
    }//OptionalDouble

    static class Member {
        String name;
        String gender;
        int age;

        public Member(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }
}
