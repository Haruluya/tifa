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
 * @TableName logistics
 */
@TableName(value ="logistics")
@Data
public class Logistics implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer lid;

    /**
     * 
     */
    private Integer oid;

    /**
     * 
     */
    private String dename;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String postalcode;

    /**
     * 
     */
    private String deid;

    /**
     * 
     */
    private Double deprice;

    /**
     * 
     */
    private String logisticsdes;

    /**
     * 
     */
    private Date detime;

    /**
     * 
     */
    private Date deendtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}