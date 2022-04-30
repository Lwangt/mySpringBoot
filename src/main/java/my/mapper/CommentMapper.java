package my.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import my.entity.Comment;
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
public interface CommentMapper extends BaseMapper<Comment> {

}
