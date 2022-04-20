package my.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.entity.UserToArticle;
import my.mapper.UserToArticleMapper;
import my.service.UserToArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwangt
 * @since 2022-04-20
 */
@Service
public class UserToArticleServiceImpl extends ServiceImpl<UserToArticleMapper, UserToArticle> implements UserToArticleService {

}
