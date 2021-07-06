package com.kaikai.digitalgame.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kaikai
 * @createTime 2021年06月29日 23:02
 * @Description : 欢迎使用
 */
@Controller
@RequestMapping("welcome")
public class WelcomeController{

    @RequestMapping("you")
    @ResponseBody
    public String welcome(){
        return "welcome you !";
    }
}
