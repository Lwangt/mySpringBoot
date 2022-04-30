package my.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
@TableName("like_record")
@ApiModel(value = "LikeRecord对象", description = "")
public class LikeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("like_id")
    private Long likeId;

    @TableField("article_id")
    private Long articleId;

    @TableField("user_id")
    private Long userId;


}
