package com.tifa.framework.web.util;


import lombok.NoArgsConstructor;


import java.util.HashMap;

@NoArgsConstructor
public class AjaxReturnValue extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static final String CODE_KEY = "statusCode";

    public static final String MSG_KEY = "message";

    public static final String DATA_KEY = "data";

    public AjaxReturnValue(int statusCode, String message)
    {
        super.put(CODE_KEY, statusCode);
        super.put(MSG_KEY, message);
    }

    public AjaxReturnValue(int statusCode, String message, Object data)
    {
        super.put(CODE_KEY, statusCode);
        super.put(MSG_KEY, message);
        super.put(DATA_KEY,data);
    }

    public static AjaxReturnValue success()
    {
        return AjaxReturnValue.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static AjaxReturnValue success(Object data)
    {
        return AjaxReturnValue.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AjaxReturnValue success(String msg)
    {
        return AjaxReturnValue.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxReturnValue success(String msg, Object data)
    {
        return new AjaxReturnValue(200, msg, data);
    }

    public static AjaxReturnValue error(int code)
    {
        return new AjaxReturnValue(code, null, null);
    }

    public static AjaxReturnValue error(int code, String msg)
    {
        return new AjaxReturnValue(code, msg, null);
    }

    public static AjaxReturnValue error(int code, String msg, Object data)
    {
        return new AjaxReturnValue(code, msg, data);
    }
}
