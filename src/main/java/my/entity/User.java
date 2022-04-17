package my.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

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

    @TableField("avatar_url")
    private String avatarUrl;

    @TableField("create_time")
    private Date createTime;

    @TableField("sex")
    private String sex;

    @TableField("follow_account")
    private Long followAccount;

    @TableField("fan_account")
    private Long fanAccount;

    @TableField("user_img")
    private String userImg;

    @TableField("salt")
    private String salt;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {

    }
}
