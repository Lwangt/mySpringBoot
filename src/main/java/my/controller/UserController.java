package my.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.entity.User;
import my.service.UserService;
import my.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PostMapping("/login")
    @ResponseBody
    public OutputObject login(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(user.getName() != null, "name", user.getName());
        User users = userService.getOne(queryWrapper);
        // 密码校验
        String s = (MD5Utils.md5(user.getPassword()+users.getSalt()));
        if (users.getPassword().equals(s)==false){
            return new OutputObject(ReturnCode.FAIL,"密码不正确",user);
        }
        queryWrapper.in(user.getPassword() != null, "password", s);
        // 通过用户名从数据库中查询出该用户
        if (users == null){
            return new OutputObject(ReturnCode.FAIL,"用户不存在",user);
        }
        String token = TokenUtil.sign(new User(user.getName(),s));
        HashMap<String,Object> hs =new HashMap<>();
        hs.put("token",token);
        hs.put("id",users.getId());
        return new OutputObject(String.valueOf(HttpStatus.OK.value()),"成功",hs);

    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    @ResponseBody
    public ResultObj addUser(@RequestBody User user) {
        try {
            // 查询用户名是否存在
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name",user.getName());
            User users = userService.getOne(queryWrapper);
            if (users!=null){
                return ResultObj.THE_USER_ALREADY_EXISTS;
            }
            // 设置盐
            String salt = UUIDUtils.getUUID();
            user.setSalt(salt);
            // 设置密码加密
            String s = MD5Utils.md5(user.getPassword()+salt);
            // 设置用户默认头像
            user.setPassword(s);
            user.setUserImg(ReturnCode.DEFAULT_IMG_USER);
            userService.save(user);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    @RequestMapping("/index")
    public String index() {
        return "Hello World! 欢迎来到 spring boot application";
    }


}
