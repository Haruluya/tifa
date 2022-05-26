package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName shoppingcart
 */
@TableName(value ="shoppingcart")
@Data
public class Shoppingcart implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer sid;

    /**
     * 
     */
    private Integer uid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}