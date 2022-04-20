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

/**
 * <p>
 * 
 * </p>
 *
 * @author lwangt
 * @since 2022-04-20
 */
@Getter
@Setter
@TableName("user_to_article")
@ApiModel(value = "UserToArticle对象", description = "")
public class UserToArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("userId")
    private Long userId;

    @TableField("articleId")
    private Long articleId;

    @ApiModelProperty("喜爱程度得分")
    @TableField("score")
    private Integer score;


}
