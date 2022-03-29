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
 * @TableName order_
 */
@TableName(value ="order_")
@Data
public class Order implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String ordercode;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String post;

    /**
     * 
     */
    private String receiver;

    /**
     * 
     */
    private String mobile;

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
    private Integer uid;

    /**
     * 
     */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}