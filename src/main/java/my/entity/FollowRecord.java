package my.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("follow_record")
@ApiModel(value = "FollowRecord对象", description = "")
public class FollowRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("follow_id")
    private Long followId;

    @TableField("follower_id")
    private Long followerId;

    @TableField("be_follow_id")
    private Long beFollowId;


}
