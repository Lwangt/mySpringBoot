package my.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("article")
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    @TableField("content")
    private String content;

    @TableField("title")
    private String title;

    @TableField("author_id")
    private Long authorId;

    @TableField("create_time")
    private LocalDate createTime;

    @TableField("like_num")
    private Integer likeNum;

    @TableField("read_num")
    private Integer readNum;

    @TableField("comment_num")
    private Integer commentNum;

    @TableField("introduction")
    private String introduction;

    @ApiModelProperty("\"js\" \"back\" \"ai\"")
    @TableField("type")
    private String type;


}
