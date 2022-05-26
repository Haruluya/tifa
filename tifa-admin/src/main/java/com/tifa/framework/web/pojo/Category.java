package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer cid;

    /**
     * 
     */
    private Integer pid;

    /**
     * 
     */
    private Integer firstparentcid;

    /**
     * 
     */
    private Integer secondparentcid;

    /**
     * 
     */
    private String cname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}