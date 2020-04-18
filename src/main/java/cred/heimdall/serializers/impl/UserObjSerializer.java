package cred.heimdall.serializers.impl;

import cred.heimdall.domain.models.User;
import cred.heimdall.serializers.ObjectToMapSerializer;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserObjSerializer implements ObjectToMapSerializer {
    @Override
    public Map<String, Object> serialize(Object o) {
        User user = (User) o;
        Map<String, Object> map = new HashMap<>();
        try {
            for(PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(User.class, Object.class).getPropertyDescriptors()){
                Method method  = propertyDescriptor.getReadMethod();
                String attribute = method.getName().replace("get", "");
                Object val = method.invoke(o, (Object)null);
                map.put(attribute, val);
            }
        }catch (Exception e){
            System.out.println("Error while Serializing user object: " + user.toString());
        }
        return map;
    }
}
