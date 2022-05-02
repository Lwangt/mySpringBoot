package my.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwangt
 * @since 2022-04-30
 */
@Getter
@Setter
@TableName("comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("parent_id")
    private Long parentId;

    @TableField("article_id")
    private Long articleId;

    @TableField("content")
    private String content;

    @TableField("create_time")
    private LocalDate createTime;

    @TableField("avatar")
    private String avatar;

    @TableField("nick_name")
    private String nickName;

    @TableField("like_count")
    private Long likeCount;

    @TableField("comment_count")
    private Long commentCount;

    @TableField("to_who")
    private String toWho;

}
