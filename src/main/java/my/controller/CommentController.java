package my.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.common.utils.AjaxResult;
import my.entity.Comment;
import my.mapper.CommentMapper;
import my.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
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
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper commentMapper;

    @PostMapping("/addComment")
    public AjaxResult addComment(@Validated @RequestBody Comment comment) {

        comment.setCreateTime(LocalDate.now());
        commentMapper.insert(comment);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @PostMapping("/deleteComment")
    public AjaxResult deleteComment(@Validated @RequestBody Comment comment) {

        long deleteId = comment.getId();
        commentMapper.deleteById(deleteId);

        AjaxResult ajax = AjaxResult.success();
        return ajax;
    }

    @PostMapping("/getCommentListByArticleId")
    public AjaxResult getCommentListByArticleId(@Validated @RequestBody Comment comment) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", comment.getId());
        List<Comment> commentList  = commentMapper.selectList(wrapper);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data",commentList);
        return ajax;
    }


}
