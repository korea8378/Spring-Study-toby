package com.toby.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Api(description = "연습", tags = {"test"})
public class SpringController {


    @ApiOperation(value = "연습", notes = "연습입니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/")
    public String Hello() {
        return "Hello Spring";
    }

}
