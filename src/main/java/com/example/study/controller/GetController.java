package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
    public String getRequest(){
        return "Hi getMethod";
    }

    // return String
    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbb";

        System.out.println("id : "+ id + " pwd :" + pwd);

        return id + pwd;
    }

    // return SearchParam
    // localhost:8080/api/multiParameter?account=abcd&email=study@gmail.com&page=10
//    @GetMapping("/getMultiParameter")
//    public String getMultiParameter(SearchParam searchParam){
//        System.out.println(searchParam.getAccount());
//        System.out.println(searchParam.getEmail());
//        System.out.println(searchParam.getPage());
//
//        return "OK";
//    }


    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : 0}
        return searchParam;
    }
}
