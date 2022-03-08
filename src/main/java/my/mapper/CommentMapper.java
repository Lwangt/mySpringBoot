package my.mapper;

import my.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwangt
 * @since 2022-03-08
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
