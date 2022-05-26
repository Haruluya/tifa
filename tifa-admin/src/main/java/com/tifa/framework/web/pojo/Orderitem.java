package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName orderitem
 */
@TableName(value ="orderitem")
@Data
public class Orderitem implements Serializable {
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
    private Integer bid;

    /**
     * 
     */
    private Integer oid;

    /**
     * 
     */
    private Integer number;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}