package my.common.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.common.exception.CustomException;
import my.common.utils.StringCustomUtils;


import my.entity.LoginUser;
import my.entity.User;
import my.mapper.UserMapper;
import my.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 用户验证处理
 *
 * @author iwhalecloud
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    private static final String LOGIN_FAIL_ERROR_TIP = "账号或密码错误";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", username);
        User user  = userMapper.selectOne(wrapper);
//        User user = userService.selectUserWithPwdByUserName(username);
        if (StringCustomUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new CustomException(LOGIN_FAIL_ERROR_TIP);
//        } else if (UserStatusDict.DELETED.getCode().equals(user.getDelFlag())) {
//            log.info("登录用户：{} 已被删除.", username);
//            throw new CustomException(LOGIN_FAIL_ERROR_TIP);
//        } else if (UserStatusDict.DISABLE.getCode().equals(user.getStatus())) {
//            log.info("登录用户：{} 已被停用.", username);
//            throw new CustomException(LOGIN_FAIL_ERROR_TIP);
//        }

        }

        return createLoginUser(user);
    }


    public UserDetails createLoginUser(User user) {
        return new LoginUser(user);
    }

}

