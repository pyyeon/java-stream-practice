package com.choongang;
import java.util.*;
import java.util.stream.Collectors;

public class D_computeCountOfFemaleMember {
    public long computeCountOfFemaleMember(List<Member> members) {
        // TODO:Member 클래스를 이용해 회원의 이름과 성별을 관리하려고 합니다.
        //  Member타입의 List를 입력받아, 여성 회원의 수를 리턴해야 합니다.
        //long타입
        return members.stream()
                .filter(member -> member.getGender().equals("female")) //filter는 추상 메서드 > 안에 채워 줘야(오버라이드) 사용가능
                .count(); // 아무것도 없을때 0으로 count하기 때문에 0 예외처리 안 해도 됨

    }

    static class Member {
        String name;
        String gender;

        public Member(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }


    }
}
