package com.nagyeong.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagyeong.basic.dto.SampleDto;

@RestController
// HTTP * localhost:4000/request-data/**
@RequestMapping("/request-data")
public class RequestDataController {
    
    // @RequestParam() :
    // - GET, DELETE처럼 URL로 데이터를 전송하는 메서드에서 Query String으로 지정된 데이터를 가져오기 위해 사용
    
    // HTTP GET localhost:4000/request-data/request-param
    @GetMapping("/request-param")
    // http://localhost:4000/request-data/request-param?userId=qwer&userName=gildong&userAge=10
    public String getRequestParam(
        @RequestParam(name="userId") String userId,
        @RequestParam(name="userName", required=false) String userName,
        @RequestParam() int userAge
    ) {
        return "사용자 아이디 : " + userId + "/ 사용자 이름 : " + userName + "/ 사용자 나이 : " + userAge;
    }

    // @PathVariable() :
    // - 모든 HTTP 메서드에서 URL의 특정 패턴에 따라서 데이터를 추출하는 방식

    //HTTP DELETE localhost:4000/request-data/path-variable
    // 여러 개를 지정해줄 경우 {} 안에 경우를 작성
    @DeleteMapping({
        "/path-variable/{age}/{name}",
        "/path-variable/{age}"
    })
    // http://localhost:4000/request-data/path-variable/10
    public String deletePathVariable(
        // int로 작성할 경우 0이 들어오게 되는데 사용자가 0을 입력한 것인지 기본값이 들어온 건지 알 수 없게 됨
        @PathVariable("age") Integer age,
        @PathVariable(name="name", required=false) String name
    ) {
        return "사용자 나이 : " + age + "/ 사용자 이름 : " + name;
    }

    // HTTP PATCH localhost:4000/request-data/patch/gildong/update
    @PatchMapping("/patch/{userName}/update")
    public String patchUpdate(
        @PathVariable("userName") String userName
    ) {
        return "사용자 이름 : " + userName;
    }

    //!***** 주의
    // URL 패턴으로 데이터를 받아오는 방식을 썼을 때 겹치는 패턴이 존재하는지 잘 확인해야 함
    // /{value}/get 와 /get/{value} 에서 value 이름이 get과 같을 경우 error code: 500 발생
    @GetMapping("/{value}/get")
    public String getPathVariable1(
        @PathVariable("value") String value
    ) {
        return "getPathVariable1";
    }
    @GetMapping("/get/{value}")
    public String getPathVariable2(
        @PathVariable("value") String value
    ) {
        return "getPathVariable2";
    }

    // @RequestBody() : 
    // - POST, PATCH, PUT처럼 RequestBody로 데이터를 전송하는 메서드에서 데이터를 가져오기 위해 사용

    // HTTP POST localhost:4000/request-data/post
    @PostMapping("/post")
    public String post(
        // @RequestBody String text
        @RequestBody SampleDto dto
    ) {
        return "전송한 데이터 : " + dto.toString();
    }

}
