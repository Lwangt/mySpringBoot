package my.service;

import my.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import my.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwangt
 * @since 2022-03-08
 */
public interface UserService extends IService<User> {

}
