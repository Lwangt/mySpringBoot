package my.controller;

import com.alibaba.fastjson.*;
import cn.hutool.core.lang.Assert;
import my.common.utils.AjaxResult;
import my.common.utils.DESUtils;
import my.common.utils.TokenUtils;
import my.vo.LoginVo;
import my.entity.User;
import my.mapper.UserMapper;
import my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @Autowired
    private TokenUtils tokenUtils;

    public static final String TOKEN = "token";


    /**
     * 登录方法
     *
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@Validated @RequestBody LoginVo loginVo) {
        User user = userService.selectUserWithPwdByUserName(loginVo.getName());
        if(user == null){
            return AjaxResult.error("用户不存在");
        }
        else{
            Assert.notNull(user,"用户不存在");
            if(!loginVo.getPassword().equals(DESUtils.decrypt(user.getPassword()))){
//                System.out.println("loginVo.getPassword ============= "+loginVo.getPassword());
//                System.out.println("user.getPassword ============= "+user.getPassword());
//                System.out.println("加密后的user.getPassword ============= "+DESUtils.decrypt(user.getPassword()));
                //密码不同则抛出异常
                return AjaxResult.error("密码不正确");
            }
            String token = tokenUtils.login(user.getName(), loginVo.getPassword());
            AjaxResult ajax = AjaxResult.success();
            ajax.put(TOKEN, token);
            ajax.put("userMessage",user);
            return ajax;
        }
    }

    @PostMapping("/addUser")
    public AjaxResult addUser(@Validated @RequestBody User user) {

       int x = userMapper.insert(user);
       System.out.println("x = "+x);
       if(x!=0) {
           AjaxResult ajax = AjaxResult.success();
           return ajax;
       }
       else {
           AjaxResult ajax = AjaxResult.error();
           return ajax;
       }
    }

    @PostMapping("/register")
    public AjaxResult register(@Validated @RequestBody LoginVo loginVo) {

        User chaxunUsers = userService.selectUserWithPwdByUserName(loginVo.getName());
        if(chaxunUsers == null){
            System.out.println("用户名没有重复");
            User user = new User();
            user.setName(loginVo.getName());
            user.setPassword(DESUtils.encrypt(loginVo.getPassword()));
            user.setCreateTime(new Date());
            userMapper.insert(user);
            AjaxResult ajax = AjaxResult.success();
            return ajax;
        }
        else{
            System.out.println("用户名重复");
            AjaxResult ajax = AjaxResult.error("用户名重复");
            return ajax;
        }

    }


    @PostMapping("/getUserNameById")
    public AjaxResult getUserNameById(@Validated @RequestBody LoginVo loginVo) {

        User user = userMapper.selectById(loginVo.getId());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("userName",user.getName());
        return ajax;
    }

    @PostMapping("/getUserLikeArticleListById")
    public AjaxResult getUserLikeArticleListById(@Validated @RequestBody LoginVo loginVo) {

        User user = userMapper.selectById(loginVo.getId());

        //fastJson输出
//        String jsonOutput= JSON.toJSONString(user);
//        System.out.println(jsonOutput);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("likeArticleList",user.getLikeArticleList());
        return ajax;
    }

}
