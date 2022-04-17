package my.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwangt
 * @since 2022-03-10
 */
@Getter
@Setter
@TableName("article")
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("article_id")
    private Long articleId;

    @TableField("content")
    private String content;

    @TableField("title")
    private String title;

    @TableField("author_id")
    private Long authorId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("like_num")
    private Integer likeNum;

    @TableField("read_num")
    private Integer readNum;

    @TableField("comment_num")
    private Integer commentNum;

    @TableField("miaoshu")
    private String miaoshu;

    @TableField("type")
    private String type;


}
