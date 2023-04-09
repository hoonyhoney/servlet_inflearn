package hello.servlet.basic.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello",20);

        //when
        Member saveMember = memberRepository.save(member);
        System.out.println("saveMember = " + saveMember.toString());
        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertEquals(findMember,saveMember);

    }

    @Test
    void findAll(){
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        //then
        Assertions.assertEquals(result.size(),2);


    }
}