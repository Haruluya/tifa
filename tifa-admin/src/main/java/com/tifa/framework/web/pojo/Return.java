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
 * @TableName return
 */
@TableName(value ="return")
@Data
public class Return implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer rid;

    /**
     * 
     */
    private Integer oid;

    /**
     * 
     */
    private Integer lid;

    /**
     * 
     */
    private String logisticsway;

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

    /**
     * 
     */
    private String returndes;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}