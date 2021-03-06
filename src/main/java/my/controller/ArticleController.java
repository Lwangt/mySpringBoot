package my.controller;


import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.common.utils.AjaxResult;
import my.entity.Article;
import my.entity.User;
import my.mapper.ArticleMapper;
import my.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwangt
 * @since 2022-03-10
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    public ArticleMapper articleMapper;

    @Autowired
    public ArticleService articleService;

    @PostMapping("/addArticle")
    public AjaxResult addArticle(@Validated @RequestBody Article article) {

            //fastJson输出
//            String jsonOutput= JSON.toJSONString(article);
//            System.out.println(jsonOutput);

            article.setCreateTime(LocalDate.now());
            articleMapper.insert(article);

            AjaxResult ajax = AjaxResult.success();
            return ajax;

    }

    @PostMapping("/deleteArticle")
    public AjaxResult deleteArticle(@RequestBody Article article) {

        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", article.getArticleId());
        articleMapper.delete(wrapper);
        System.out.println("删除了文章 articleId = "+ article.getArticleId());

        AjaxResult ajax = AjaxResult.success();
        return ajax;

    }

    @PostMapping("/getArticleByList")
    public AjaxResult getArticleByList(@Validated @RequestBody List<Long> list) {

        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.in("article_id", list);
        List<Article> article  = articleMapper.selectList(wrapper);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",article);
        return ajax;
    }

    @PostMapping("/getArticleListByType")
    public AjaxResult getArticleListByType(@Validated @RequestBody Article article) {

        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("type", article.getType());
        List<Article> articleList  = articleMapper.selectList(wrapper);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",articleList);
        return ajax;
    }

    @PostMapping("/getArticleListByAuthorId")
    public AjaxResult getArticleListByAuthorId(@Validated @RequestBody User user) {

        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("author_id", user.getId());
        List<Article> articleList  = articleMapper.selectList(wrapper);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",articleList);
        return ajax;
    }


    @GetMapping("/getArticleListRandom")
    public AjaxResult getArticleListRandom() {

        // 总记录数
        long count = articleService.count();
        // 随机数起始位置
        long randomCount =(long) (Math.random()*count);
        // 数字太大 不够的话 保证能展示最后10个数据
        if (randomCount > count-10) {
            randomCount =  count - 10 ;
        }

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("article_id");
        wrapper.last("limit "+ String.valueOf(randomCount) +", 10");
        List<Article> randomList = articleMapper.selectList(wrapper);

        //fastJson输出
//        String jsonOutput= JSON.toJSONString(randomList);
//        System.out.println(jsonOutput);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",randomList);
        return ajax;

    }



}
