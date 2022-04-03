package my.mapper;

import my.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwangt
 * @since 2022-03-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    User selectUserByName(String name);
}
