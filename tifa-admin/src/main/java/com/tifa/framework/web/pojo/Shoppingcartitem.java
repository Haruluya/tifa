package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName shoppingcartitem
 */
@TableName(value ="shoppingcartitem")
@Data
public class Shoppingcartitem implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer sid;

    /**
     * 
     */
    private Integer pid;

    /**
     * 
     */
    private Integer num;

    /**
     * 
     */
    private Date createdate;

    /**
     * 
     */
    private Date updatedate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}