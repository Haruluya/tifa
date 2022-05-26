package com.tifa.framework.web.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */

    @TableId(type = IdType.AUTO )
    private Integer uid;

    /**
     * 
     */
    private String uname;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String headpicture;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private Integer bid;

    /**
     * 
     */
    private String persignature;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}