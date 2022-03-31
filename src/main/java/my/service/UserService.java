package my.service;

import my.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwangt
 * @since 2022-03-10
 */
public interface UserService extends IService<User> {

    /**
     * 通过用户名查询用户
     *返回用户信息中包含密码
     * @param name 用户名
     * @return 用户对象信息
     */
    User selectUserWithPwdByUserName(String name);
}
