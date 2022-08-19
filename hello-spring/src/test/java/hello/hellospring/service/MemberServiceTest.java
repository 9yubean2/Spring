package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemoryMemberRepository memoryMemberRepository;
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        //주어진 상황
        Member member = new Member();
        member.setName("spring");

        //when
        //이 메서드를 실행했을 때
        Long saveId = memberService.join(member);

        //then
        //어떻게
        Member findMember  = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo((findMember.getName()));
    }

    @Test
    public void validate() {
        //given
        //주어진 상황
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        //이 메서드를 실행했을 때
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("Already Exist");
//        try{
//            memberService.join(member2);
//            fail("Exception");
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("Already Exist 123123");
//        }

    }



    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}