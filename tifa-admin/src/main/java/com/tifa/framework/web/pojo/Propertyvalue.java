package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName propertyvalue
 */
@TableName(value ="propertyvalue")
@Data
public class Propertyvalue implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer id;

    /**
     * 
     */
    private Integer pid;

    /**
     * 
     */
    private Integer ptid;

    /**
     * 
     */
    private String value;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}