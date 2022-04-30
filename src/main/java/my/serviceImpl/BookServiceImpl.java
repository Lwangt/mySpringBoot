package my.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.entity.Book;
import my.mapper.BookMapper;
import my.service.BookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwangt
 * @since 2022-04-30
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
