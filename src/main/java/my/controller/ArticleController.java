package my.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.common.utils.AjaxResult;
import my.entity.Article;
import my.entity.Comment;
import my.entity.User;
import my.mapper.ArticleMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    ArticleMapper articleMapper;

    @PostMapping("/addArticle")
    public AjaxResult addArticle(@Validated @RequestBody Article article) {

            articleMapper.insert(article);

            AjaxResult ajax = AjaxResult.success();
            return ajax;

    }

    @PostMapping("/deleteArticle")
    public AjaxResult deleteArticle(@RequestBody Map<String, Object> obj) {

        if(obj.get("authorId")!=obj.get("id")) {
            AjaxResult ajax = AjaxResult.error("没有权限删除");
            return ajax;
        }
        else {
            AjaxResult ajax = AjaxResult.success();
            return ajax;
        }
    }

    @PostMapping("/getArticleList")
    public AjaxResult getArticleList(@Validated @RequestBody Article article) {

        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("type", article.getType());
        List<Article> articletList  = articleMapper.selectList(wrapper);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",articletList);
        return ajax;
    }


}
