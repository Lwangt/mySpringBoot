
import my.Application;
import my.entity.Article;
import my.entity.User;
import my.mapper.ArticleMapper;
import my.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("cc");
        user.setPassword("123456");
        System.out.println(user);
        int result = this.userMapper.insert(user);
        System.out.println(result);

    }

    @Test
    public void articleSelect() {
        List<Article> articleList = articleMapper.selectList(null);
        for(Article article:articleList) {
            System.out.println(article.getContent());
        }
    }

}
