package cred.heimdall.serializers;

import java.beans.IntrospectionException;
import java.util.Map;

public interface ObjectToMapSerializer {

    Map<String, Object> serialize(Object o);
}
