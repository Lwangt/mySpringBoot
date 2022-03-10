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
@TableName("type")
@ApiModel(value = "Type对象", description = "")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("type_id")
    private Long typeId;

    @TableField("type_name")
    private String typeName;

    @TableField("type_num")
    private Integer typeNum;


}
