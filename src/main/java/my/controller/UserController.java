package my.controller;


import cn.hutool.core.lang.Assert;
import my.common.utils.AjaxResult;
import my.common.utils.DESUtils;
import my.common.utils.TokenUtils;
import my.entity.LoginVo;
import my.entity.User;
import my.mapper.UserMapper;
import my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/index")
    public String index() {
        return "Hello World! 欢迎来到 spring boot application";
    }

    /**
     * 登录方法
     *
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@Validated @RequestBody LoginVo loginVo) {
            User user = userService.selectUserWithPwdByUserName(loginVo.getName());
        Assert.notNull(user,"用户不存在");
        if(!loginVo.getPassword().equals(DESUtils.decrypt(user.getPassword()))){
            //密码不同则抛出异常
            return AjaxResult.error("密码不正确");
        }
        String token = tokenUtils.login(user.getName(), loginVo.getPassword());
        AjaxResult ajax = AjaxResult.success();
        ajax.put(TOKEN, token);
        return ajax;
    }


}
