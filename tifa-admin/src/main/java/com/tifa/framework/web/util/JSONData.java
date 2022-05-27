package com.tifa.framework.web.util;


import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 规范模拟json数据，模拟ajaxreturnvalue中的data。
 * @author haruluya
 * @date 2022/4/9
 */
public class JSONData extends HashMap<String,Object> {
    /**
     * 将bean转化为map。
     * @param object
     * @return
     */
    public static Map<String, Object> convertBeanToMap(Object object)
    {
        if(object == null){
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!key.equals("class")) {
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(object);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
