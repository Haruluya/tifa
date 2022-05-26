package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName business
 */
@TableName(value ="business")
@Data
public class Business implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer bid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String personidentity;

    /**
     * 
     */
    private String businessdes;

    /**
     * 
     */
    private String businessclass;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}