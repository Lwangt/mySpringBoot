package my.controller;
import my.common.utils.AjaxResult;
import my.entity.UserToArticle;
import my.mapper.UserToArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwangt
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/user-to-article")
public class UserToArticleController {

    @Autowired
    public UserToArticleMapper userToArticleMapper;

    @PostMapping("/addScoreRecord")
    public AjaxResult addScoreRecord(@Validated @RequestBody UserToArticle userToArticle){
        int x = userToArticle.getScore();

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }



}