package serializers;

import cred.heimdall.constants.Gender;
import cred.heimdall.domain.models.User;
import cred.heimdall.serializers.ObjectToMapSerializer;
import cred.heimdall.serializers.impl.UserObjSerializer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class UserObjSerializerTest {
    private ObjectToMapSerializer objectToMapSerializer = new UserObjSerializer();

    @Test
    public void testUserSerialization(){
        User user = new User();
        String name = "Suman Saurabh";
        String email = "sumansaurabh93s@gmail.com";
        String phone = "8505947133";
        String address = "Sobha Mayflower, Bellandur";
        int pincode = 560103;
        Gender gender = Gender.Male;
        int age = 25;
        String city = "Bengaluru";
        String state = "Karnataka";
        float pastOrderAmount = 1000;
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setPincode(pincode);
        user.setGender(gender);
        user.setAge(age);
        user.setCity(city);
        user.setState(state);
        user.setPastOrderAmount(pastOrderAmount);
        Map<String, Object> map = objectToMapSerializer.serialize(user);
        Assert.assertEquals(map.size(), 11);
        Assert.assertNotNull(map.get("name"));
        Assert.assertNotNull(map.get("email"));
        Assert.assertNotNull(map.get("phone"));
        Assert.assertNotNull(map.get("address"));
        Assert.assertNotNull(map.get("pincode"));
        Assert.assertNotNull(map.get("gender"));
        Assert.assertNotNull(map.get("age"));
        Assert.assertNotNull(map.get("city"));
        Assert.assertNotNull(map.get("state"));
        Assert.assertNotNull(map.get("pastorderamount"));
        Assert.assertNotNull(map.get("active"));
    }
}
