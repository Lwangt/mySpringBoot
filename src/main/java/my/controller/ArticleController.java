package my.controller;


import my.entity.Article;
import my.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class ArticleController {

    @Autowired
    ArticleMapper articleMapper;
//
//    //    根据文章id获得文章实体
//    @RequestMapping(path = "/getUserArticle/{id}", method = RequestMethod.GET)
//    public ResultObj getUserArticle(@PathVariable Long id){
//        Article article = articleMapper.selectById(id);
//        System.out.println(article);
//        return ResultObj.ADD_SUCCESS;
//    }
//
//    //    查询全部文章实体
//    @RequestMapping(path = "/getAllArticle", method = RequestMethod.GET)
//    public void articleSelect() {
//
//        List<Article> articleList = articleMapper.selectList(null);
//        for(Article article:articleList) {
//            System.out.println(article);
//        }
//    }

}
