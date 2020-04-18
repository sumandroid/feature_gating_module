package cred.heimdall.evaluators;

import cred.heimdall.serializers.ObjectToMapSerializer;
import java.util.Map;

public class Context {
    private Map<String, Object> attributeMap;

    public Context(Object o, ObjectToMapSerializer serializer){
        attributeMap = serializer.serialize(o);
    }

    public Map<String, Object> getAttributeMap(){
        return attributeMap;
    }

    public Object getAttributeVal(String attributeName){
        return attributeMap.get(attributeName);
    }
}
