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
 * @TableName order
 */
@TableName(value ="`order`")
@Data
public class Order implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer oid;

    /**
     * 
     */
    private Integer uid;

    /**
     * 
     */
    private Integer aid;

    /**
     * 
     */
    private String usermessage;

    /**
     * 
     */
    private Date createdate;

    /**
     * 
     */
    private Date paydate;

    /**
     * 
     */
    private Date deliverydate;

    /**
     * 
     */
    private Date confirmdate;

    /**
     * 
     */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}