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
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String subtitle;

    /**
     * 
     */
    private Double orignalprice;

    /**
     * 
     */
    private Double promoteprice;

    /**
     * 
     */
    private Integer stock;

    /**
     * 
     */
    private Integer cid;

    /**
     * 
     */
    private Date createdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}