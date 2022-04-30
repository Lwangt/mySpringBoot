package my.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.common.utils.AjaxResult;
import my.common.utils.StringCustomUtils;
import my.entity.Article;
import my.entity.Comment;
import my.entity.User;
import my.mapper.ArticleMapper;
import my.mapper.CommentMapper;
import my.mapper.UserMapper;
import my.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwangt
 * @since 2022-03-10
 */
@RestController
public class SearchController {

    @Autowired
    public ArticleMapper articleMapper;

    @Autowired
    public ArticleService articleService;

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public CommentMapper commentMapper;


    @PostMapping("/searchByArticleTitle")
    public AjaxResult searchByArticleTitle(@Validated @RequestBody Article article) {

        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.like("title", article.getTitle());
        System.out.println( " ====  type is " + article.getType());
        wrapper.eq(!StringCustomUtils.isNullOrEmpty(article.getType()),"type", article.getType());
        List<Article> list  = articleMapper.selectList(wrapper);

        //fastJson输出
//        String jsonOutput= JSON.toJSONString(list);
//        System.out.println(jsonOutput);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",list);
        return ajax;

    }

    @PostMapping("/searchByArticleContent")
    public AjaxResult searchByArticleContent(@Validated @RequestBody Article article) {

        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.like("content", article.getContent());
        wrapper.eq(!StringCustomUtils.isNullOrEmpty(article.getType()),"type", article.getType());
        List<Article> list  = articleMapper.selectList(wrapper);

        //fastJson输出
//        String jsonOutput= JSON.toJSONString(list);
//        System.out.println(jsonOutput);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",list);
        return ajax;

    }

    @PostMapping("/searchByUserName")
    public AjaxResult searchByUserName(@Validated @RequestBody User user) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", user.getName());
        List<User> list  = userMapper.selectList(wrapper);

        //fastJson输出
//        String jsonOutput= JSON.toJSONString(list);
//        System.out.println(jsonOutput);


        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",list);
        return ajax;

    }

    @PostMapping("/searchByComment")
    public AjaxResult searchByComment(@Validated @RequestBody Comment comment) {

        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.like("content", comment.getContent());
        List<Comment> list  = commentMapper.selectList(wrapper);

        //fastJson输出
//        String jsonOutput= JSON.toJSONString(list);
//        System.out.println(jsonOutput);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",list);
        return ajax;

    }

}
