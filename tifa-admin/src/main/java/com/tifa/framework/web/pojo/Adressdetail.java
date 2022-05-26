package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName adressdetail
 */
@TableName(value ="adressdetail")
@Data
public class Adressdetail implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer aid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String standbyphone;

    /**
     * 
     */
    private String countries;

    /**
     * 
     */
    private String provinces;

    /**
     * 
     */
    private String city;

    /**
     * 
     */
    private String detailaddress;

    /**
     * 
     */
    private String postalcode;

    /**
     * 
     */
    private String isdefault;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}