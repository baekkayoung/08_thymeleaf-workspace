package com.kh.tymeleaf.controller;

import com.kh.tymeleaf.member.model.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Controller
@RequestMapping("/th") // 기본 어노테이션 => 모든 HTTP 메서드 처리 가능! (GET, POST, PUT, DELETE 방식 전부)
public class ThymleafBasicController {

   @GetMapping("/text") // Spring 4.3버전부터 추가됨! GET 요청만 처리함!
    public String basic(Model model){
        model.addAttribute("msg","thymeleaf 이용하기");
        model.addAttribute("data", "kh");
        return "Basic/text_test";
    }

    @GetMapping("/opr")
    public String opTest(){

       return "basic/op_test";
    }

    @GetMapping("/form") // get mapping
    public String getFormTest(Model model){
       model.addAttribute("data", "thymeleaf");
       return "basic/form_test";
    }

    @PostMapping("/form") // post mapping
    public String postFormTest(String test2, String thymeleaf){
        System.out.println("test2 : " + test2);
        System.out.println("thymeleaf : " + thymeleaf);
        return "basic/form_test"; // data가 없어서 첫 번째 인풋 박스가 비워짐
    }

    @GetMapping("/if")
    public String ifTest(Model model){
       model.addAttribute("score",20);
       return "basic/if_test";
    }

    @GetMapping("/loop")
    public String loopTest(Model model){
        Member m1 = new Member("user01", "pass01", "차은우", 19);
        Member m2 = new Member("user02", "pass02", "김은우", 25);
        Member m3 = new Member("user03", "pass03", "박은우", 30);
        Member m4 = new Member("user04", "pass04", "이은우", 17);

        ArrayList<Member> list = new ArrayList<Member>(); // []
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        model.addAttribute("list",list); // 검색, 조회
        model.addAttribute("member", m1); // 결과 1개인 경우

        return "basic/loop_test";
    }

    @GetMapping("/href")
    public String hrefTest(){
       return "basic/href_test";

    }

    @GetMapping("/checked")
    public String checkedTest(Model model){
        model.addAttribute("isChecked", true);
        return "basic/href_test";
    }

}
