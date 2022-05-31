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
 * @TableName review
 */
@TableName(value ="review")
@Data
public class Review implements Serializable {
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
    private String content;

    /**
     * 
     */
    private Date createdate;


    private Integer rate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}