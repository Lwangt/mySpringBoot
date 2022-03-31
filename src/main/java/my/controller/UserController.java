package my.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.entity.Article;
import my.entity.User;
import my.mapper.UserMapper;
import my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwangt
 * @since 2022-03-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/index")
    public String index() {
        return "Hello World! 欢迎来到 spring boot application";
    }





}
