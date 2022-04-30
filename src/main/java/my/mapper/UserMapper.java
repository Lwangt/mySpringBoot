package my.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import my.entity.User;
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


//    User selectUserByName(String name);

}
