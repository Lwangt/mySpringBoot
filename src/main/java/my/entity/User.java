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
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("create_time")
    private LocalDate createTime;

    @TableField("sex")
    private String sex;

    @TableField("follow_account")
    private Long followAccount;

    @TableField("fan_account")
    private Long fanAccount;

    @TableField("user_img")
    private String userImg;

    @ApiModelProperty("用 , 来分割")
    @TableField("like_article_list")
    private String likeArticleList;


}
