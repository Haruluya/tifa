package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName rating
 */
@TableName(value ="rating")
@Data
public class Rating implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO )
    private Integer rid;

    /**
     * 
     */
    private Integer uid;

    /**
     * 
     */
    private Integer pid;

    /**
     * 
     */
    private Integer score;

    /**
     * 
     */
    private String timestamp;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}