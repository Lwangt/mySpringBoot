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
@TableName("book")
@ApiModel(value = "Book对象", description = "")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("num")
    private Long num;

    @TableField("price")
    private Double price;

    @TableField("site")
    private String site;

    @TableField("sell_out")
    private Integer sellOut;

    @TableField("content")
    private String content;


}
