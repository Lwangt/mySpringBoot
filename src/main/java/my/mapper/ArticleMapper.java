package my.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import my.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwangt
 * @since 2022-04-30
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
